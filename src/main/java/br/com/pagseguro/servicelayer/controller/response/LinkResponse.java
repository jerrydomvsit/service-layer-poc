package br.com.pagseguro.servicelayer.controller.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LinkResponse {
    private String url;
    private String linkId;
    private String linkName;
    private String merchant;
    private Long amount;
    private LocalDateTime creation;
    private LocalDateTime updated;
    private LocalDate dueDate;
    private int daysToExpire;
    private String status;
    private DebtorResponse debtor;
    private String paymentCode;
    private String chargeId;
    private String userAgent;
    private String paymentStatus;
}
