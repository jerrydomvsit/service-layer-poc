package br.com.pagseguro.servicelayer.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DebtorPhoneModel {
    private String areaCode;
    private String number;
}