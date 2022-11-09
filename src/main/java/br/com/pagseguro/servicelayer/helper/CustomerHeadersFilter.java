package br.com.pagseguro.servicelayer.helper;

import br.com.pagseguro.servicelayer.exception.ErrorType;
import br.com.pagseguro.servicelayer.model.ErrorResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;
import org.springframework.web.util.NestedServletException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Validation;
import javax.validation.ValidatorFactory;
import java.io.IOException;

@Component
@Slf4j
public class CustomerHeadersFilter extends GenericFilterBean {

    private final String headersErrorResponse;
    private final String internalErrorResponse;
    private final String secondaryUserErrorResponse;

    @SneakyThrows
    public CustomerHeadersFilter(
            ObjectMapper objectMapper) {
        this.headersErrorResponse =
                objectMapper.writeValueAsString(getErrorBody(ErrorType.INVALID_PARAMETERS));
        this.internalErrorResponse =
                objectMapper.writeValueAsString(getErrorBody(ErrorType.INTERNAL_ERROR));
        this.secondaryUserErrorResponse =
                objectMapper.writeValueAsString(getErrorBody(ErrorType.SECONDARY_USER_ERROR));
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws ServletException, IOException {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();

        final var httpRequest = (HttpServletRequest) request;
        final var httpResponse = (HttpServletResponse) response;

        if (httpRequest.getRequestURI().startsWith("/web")) {
            final var billHeaders =
                    CustomerHeaders.builder()
                            .ownerCustomerId(httpRequest.getHeader("X-CustomerId"))
                            .customerId(httpRequest.getHeader("X-Auth-CustomerId"))
                            .safePayUserId(tryParseLong(httpRequest.getHeader("X-UserId")))
                            .build();
            final var violations = factory.getValidator().validate(billHeaders);
            if (violations.isEmpty()) {
                try {
                    request.setAttribute("customerHeaders", billHeaders);
                    if (verifyMainUser(httpResponse, billHeaders)) {
                        chain.doFilter(request, response);
                    }
                } catch (NestedServletException e) {
                    writeResponse(
                            httpResponse, ErrorType.INTERNAL_ERROR.getStatusCode(), internalErrorResponse);
                } catch (Exception e) {
                    writeResponse(
                            httpResponse, ErrorType.INTERNAL_ERROR.getStatusCode(), internalErrorResponse);
                }
            } else {
                writeResponse(
                        httpResponse, ErrorType.INVALID_PARAMETERS.getStatusCode(), headersErrorResponse);
            }
            return;
        }
        chain.doFilter(request, response);
    }

    private boolean verifyMainUser(HttpServletResponse httpResponse, CustomerHeaders customerHeaders)
            throws IOException {
        if (customerHeaders.getCustomerId().equals(customerHeaders.getOwnerCustomerId())) {
            return true;
        } else {
            writeResponse(
                    httpResponse, ErrorType.SECONDARY_USER_ERROR.getStatusCode(), secondaryUserErrorResponse);
            return false;
        }
    }

    private void writeResponse(HttpServletResponse httpResponse, int status, String response)
            throws IOException {
        httpResponse.setContentType("application/json; charset=utf-8");
        httpResponse.setStatus(status);
        httpResponse.getWriter().write(response);
    }

    private Long tryParseLong(String s) {
        if (StringUtils.isNumeric(s)) {
            return Long.parseLong(s);
        }
        return null;
    }

    private ErrorResponse getErrorBody(ErrorType error) {
        return ErrorResponse.builder()
                .code(error.getErrorCode())
                .title(error.getResponseTitle())
                .message(error.getResponseMessage())
                .build();
    }
}
