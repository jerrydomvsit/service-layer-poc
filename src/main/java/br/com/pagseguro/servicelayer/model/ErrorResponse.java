package br.com.pagseguro.servicelayer.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.util.Map;

@Data
@Slf4j
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ErrorResponse {
    private final String title;
    private final String message;
    private final String code;

    Map<String, ?> details;

    public static ErrorResponse fromDefaultException(DefaultException defaultException) {

        final var details =
                Map.of("message", StringUtils.defaultString(defaultException.getCause().toString(), "Valor inválido"));

        log.error("EX={}", details);

        return ErrorResponse.builder()
                .title(defaultException.getResponseTitle())
                .message(defaultException.getResponseMessage())
                .code(defaultException.getErrorCode())
                .build();
    }
}
