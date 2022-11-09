package br.com.pagseguro.servicelayer.datasource.http;

import br.com.pagseguro.servicelayer.model.BillsModel;

public interface BillsGateway {
    BillsModel getBills(String customerId, String linkName, String status, int limit, int offset);
}
