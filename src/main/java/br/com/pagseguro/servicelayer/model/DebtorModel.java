package br.com.pagseguro.servicelayer.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DebtorModel {
    private String name;
    private DebtorDocumentModel debtorDocument;
    private String email;
    private DebtorPhoneModel debtorPhone;
    private DebtorAddressModel debtorAddress;
    private boolean registered;
}
