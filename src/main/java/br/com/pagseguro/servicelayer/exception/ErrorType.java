package br.com.pagseguro.servicelayer.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum ErrorType {
  INTERNAL_ERROR(500, "BC002", Constants.INTERNAL_ERROR_TITLE, Constants.INTERNAL_ERROR_MESSAGE),
  INVALID_PARAMETERS(
      422, "BC001", Constants.INTERNAL_ERROR_TITLE, Constants.INTERNAL_ERROR_MESSAGE),

  RECEIPT_NOT_FOUND(404, "PC110", Constants.INTERNAL_ERROR_TITLE, Constants.INTERNAL_ERROR_MESSAGE),

  SECONDARY_USER_ERROR(
      400,
      "BC003",
          Constants.INTERNAL_ERROR_TITLE,
          Constants.INTERNAL_ERROR_MESSAGE);

  private final int statusCode;

  private final String errorCode;

  private final String responseTitle;
  private final String responseMessage;

  private static class Constants {
    private static final String INTERNAL_ERROR_TITLE = "Algo deu errado";
    private static final String INTERNAL_ERROR_MESSAGE =
        "Não foi possível completar sua ação.\nTente novamente mais tarde.";
  }
}
