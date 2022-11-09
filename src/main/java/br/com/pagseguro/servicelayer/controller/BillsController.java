package br.com.pagseguro.servicelayer.controller;

import br.com.pagseguro.servicelayer.controller.request.PaymentStatusRequest;
import br.com.pagseguro.servicelayer.controller.response.BillsResponse;
import br.com.pagseguro.servicelayer.helper.CustomerHeaders;
import br.com.pagseguro.servicelayer.mapper.BillsMapper;
import br.com.pagseguro.servicelayer.service.BillsService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
@Tag(name = "Bills")
@ApiResponses(
        value = {
                @ApiResponse(responseCode = "200", description = "Return when request success"),
                @ApiResponse(
                        responseCode = "500",
                        description = "Server error, generic and worth looking at other level 500 errors"),
        })
public class BillsController {
        private final BillsMapper mapper;
        private final BillsService billsService;

        @Operation(summary = "Gets available information of all links with redirectType = CHARGE_BOLETO.", parameters = {
                @Parameter(name = "X-CustomerId", in = ParameterIn.HEADER, required = true),
                @Parameter(name = "X-Auth-CustomerId", in = ParameterIn.HEADER, required = true),
                @Parameter(name = "X-UserId", in = ParameterIn.HEADER, required = true),
                @Parameter(name = "X-RiskId", in = ParameterIn.HEADER)
        })
        @GetMapping("/web/bills")
        public ResponseEntity<BillsResponse> getBills(@RequestAttribute("customerHeaders") CustomerHeaders customerHeaders,
                                                      @Valid @RequestParam(value = "linkName", required = false, defaultValue = "") String linkName,
                                                      @Valid @RequestParam(value = "status", required = false, defaultValue = "") List<PaymentStatusRequest> status,
                                                      @Valid @RequestParam(value = "limit", required = false, defaultValue = "10") @Min(10) int limit,
                                                      @Valid @RequestParam(value = "offset", required = false, defaultValue = "0") @Min(0) int offset) {


                var bills = billsService.getBills(customerHeaders.getCustomerIdLegacy(), linkName,PaymentStatusRequest.fromString(status) , limit, offset);
                final BillsResponse billsResponse = mapper.modelToResponse(bills);
                return ResponseEntity.ok(billsResponse);
//                return ResponseEntity.ok(BillsResponse.builder().build());
        }
}
