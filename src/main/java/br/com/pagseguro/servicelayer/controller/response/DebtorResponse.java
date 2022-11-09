package br.com.pagseguro.servicelayer.controller.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DebtorResponse {
    private String name;
    private DebtorDocumentResponse debtorDocument;
    private String email;
    private DebtorPhoneResponse debtorPhone;
    private DebtorAddressResponse debtorAddress;
    private boolean registered;
}
