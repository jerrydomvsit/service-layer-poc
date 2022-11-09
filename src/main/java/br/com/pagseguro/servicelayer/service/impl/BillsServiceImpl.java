package br.com.pagseguro.servicelayer.service.impl;

import br.com.pagseguro.servicelayer.datasource.http.BillsGateway;
import br.com.pagseguro.servicelayer.model.BillsModel;
import br.com.pagseguro.servicelayer.service.BillsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BillsServiceImpl implements BillsService {
    private final BillsGateway billsGateway;

    @Override
    public BillsModel getBills(String customerId, String linkName, String status, int limit, int offset) {
        try {
            return billsGateway.getBills(customerId, linkName, status, limit, offset);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }

    }
}
