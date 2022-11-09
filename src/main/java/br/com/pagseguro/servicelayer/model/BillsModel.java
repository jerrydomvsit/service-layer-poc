package br.com.pagseguro.servicelayer.model;

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
public class BillsModel {
    public List<LinkModel> links;
    public PaginationModel pagination;
    public boolean firstTimeUser;
    public boolean boletoEnabled;
    public boolean boletoBlocked;
    public LimitModel boletoLimit;

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class LinkModel {
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
        public DebtorModel debtor;
        public String paymentCode;
        public String chargeId;
        public String userAgent;
        public String paymentStatus;

        @Data
        @Builder
        @AllArgsConstructor
        @NoArgsConstructor
        public static class DebtorModel {
            public String name;
            public DebtorDocumentModel debtorDocument;
            public String email;
            public DebtorPhoneModel debtorPhone;
            public DebtorAddressModel debtorAddress;
            public boolean registered;

            @Data
            @Builder
            @AllArgsConstructor
            @NoArgsConstructor
            public static class DebtorDocumentModel {
                public String type;
                public String number;
            }

            @Data
            @Builder
            @AllArgsConstructor
            @NoArgsConstructor
            public static class DebtorPhoneModel {
                public String areaCode;
                public String number;
            }

            @Data
            @Builder
            @AllArgsConstructor
            @NoArgsConstructor
            public static class DebtorAddressModel  {
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
    public static class PaginationModel {
        public int total;
    }

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class LimitModel {
        public Long totalValue;
        public Long currentValue;
        public Integer totalQuantity;
        public Integer currentQuantity;
    }

}
