package br.com.pagseguro.servicelayer.controller.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DebtorAddressResponse  {
    private String street;
    private String number;
    private String complement;
    private String district;
    private String postalCode;
    private String city;
    private String state;
    private boolean defaultAddress;
}