package br.com.pagseguro.servicelayer.controller.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BillsResponse {
    public List<LinkResponse> links;
    public PaginationResponse pagination;
    public boolean firstTimeUser;
    public boolean boletoEnabled;
    public boolean boletoBlocked;
    public LimitResponse boletoLimit;

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class LinkResponse {
        public String url;
        public String linkId;
        public String linkName;
        public String merchant;
        public Long amount;
        public LocalDateTime creation;
        public LocalDateTime updated;
        public LocalDate dueDate;
        public int daysToExpire;
        public String status;
        public DebtorResponse debtor;
        public String paymentCode;
        public String chargeId;
        public String userAgent;
        public String paymentStatus;

        @Data
        @Builder
        @AllArgsConstructor
        @NoArgsConstructor
        public static class DebtorResponse {
            public String name;
            public DebtorDocumentResponse debtorDocument;
            public String email;
            public DebtorPhoneResponse debtorPhone;
            public DebtorAddressResponse debtorAddress;
            public boolean registered;

            @Data
            @Builder
            @AllArgsConstructor
            @NoArgsConstructor
            public static class DebtorDocumentResponse {
                public String type;
                public String number;
            }

            @Data
            @Builder
            @AllArgsConstructor
            @NoArgsConstructor
            public static class DebtorPhoneResponse {
                public String areaCode;
                public String number;
            }

            @Data
            @Builder
            @AllArgsConstructor
            @NoArgsConstructor
            public static class DebtorAddressResponse  {
                public String street;
                public String number;
                public String complement;
                public String district;
                public String postalCode;
                public String city;
                public String state;
                public boolean defaultAddress;
            }
        }
    }

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class PaginationResponse {
        public int total;
    }

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class LimitResponse {
        public Long totalValue;
        public Long currentValue;
        public Integer totalQuantity;
        public Integer currentQuantity;
    }

}
