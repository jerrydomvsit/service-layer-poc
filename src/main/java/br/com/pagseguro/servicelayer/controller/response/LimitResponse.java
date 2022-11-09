package br.com.pagseguro.servicelayer.controller.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LimitResponse {
    private Long totalValue;
    private Long currentValue;
    private Integer totalQuantity;
    private Integer currentQuantity;
}