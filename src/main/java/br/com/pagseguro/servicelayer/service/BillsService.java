package br.com.pagseguro.servicelayer.service;

import br.com.pagseguro.servicelayer.model.BillsModel;

public interface BillsService {
    BillsModel getBills(String customerId, String linkName, String status, int limit, int offset);
}
