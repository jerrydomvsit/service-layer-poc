package br.com.pagseguro.servicelayer.helper;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.UUID;

import static br.com.pagseguro.servicelayer.helper.CustomerId.legacyToUUID;

@Data
@Builder
public class CustomerHeaders {
  private static final String CUSTOMER_ID_PATTERN = "CUSTOMER:[0-9A-F]{32}";


  @NotEmpty
  @Pattern(regexp = CUSTOMER_ID_PATTERN)
  private String customerId;

  @NotEmpty
  @Pattern(regexp = CUSTOMER_ID_PATTERN)
  private String ownerCustomerId;

  @NotNull private Long safePayUserId;

  private String userIp;
  private String riskId;

  public UUID getCustomerIdUUID() {
    return legacyToUUID(customerId);
  }

  public String getCustomerIdLegacy() {
    return customerId;
  }

  public UUID getOwnerCustomerIdUUID() {
    return legacyToUUID(ownerCustomerId);
  }
}
