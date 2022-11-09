package br.com.pagseguro.servicelayer.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DebtorAddressModel {
    private String street;
    private String number;
    private String complement;
    private String district;
    private String postalCode;
    private String city;
    private String state;
    private boolean defaultAddress;
}