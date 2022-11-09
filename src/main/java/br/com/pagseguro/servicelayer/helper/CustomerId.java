package br.com.pagseguro.servicelayer.helper;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.UUID;
import java.util.regex.Pattern;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CustomerId {
  private static final String INIT_STRING = "CUSTOMER:";
  private static final Pattern regex =
      Pattern.compile(
          "(\\p{XDigit}{8})(\\p{XDigit}{4})(\\p{XDigit}{4})(\\p{XDigit}{4})(\\p{XDigit}+)");

  public static UUID legacyToUUID(String billId) {
    final var uuidString =
        regex.matcher(billId.substring(INIT_STRING.length())).replaceFirst("$1-$2-$3-$4-$5");
    return UUID.fromString(uuidString);
  }
}
