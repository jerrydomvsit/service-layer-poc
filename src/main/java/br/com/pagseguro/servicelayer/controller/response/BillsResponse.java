package br.com.pagseguro.servicelayer.controller.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BillsResponse {
    private List<LinkResponse> links;
    private PaginationResponse pagination;
    private boolean firstTimeUser;
    private boolean boletoEnabled;
    private boolean boletoBlocked;
    private LimitResponse boletoLimit;
}
