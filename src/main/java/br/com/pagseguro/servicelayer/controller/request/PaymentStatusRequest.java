package br.com.pagseguro.servicelayer.controller.request;


import com.fasterxml.jackson.annotation.JsonCreator;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;


public enum PaymentStatusRequest {

    WAITING("waiting"), OVERDUE("overdue"), PAID("paid"), REQUESTED("requested"), REGISTERED("registered"), NOT_PAID(
            "not_paid");

    private final String key;

    PaymentStatusRequest(final String key) {
        this.key = key;
    }

    @JsonCreator
    public static String fromString(List<PaymentStatusRequest> statusRequestList) {
        List<String> strings = statusRequestList.stream()
                .map(object -> Objects.toString(object, null))
                .collect(Collectors.toList());
        return statusRequestList == null  ? null : String.join(",", strings) ;

    }

}
