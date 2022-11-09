package br.com.pagseguro.servicelayer.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BillsModel {
    private List<LinkModel> links;
    private PaginationModel pagination;
    private boolean firstTimeUser;
    private boolean boletoEnabled;
    private boolean boletoBlocked;
    private LimitModel boletoLimit;
}
