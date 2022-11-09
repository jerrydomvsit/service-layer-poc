package br.com.pagseguro.servicelayer.datasource.http.feignclient;

import br.com.pagseguro.servicelayer.datasource.http.BillsGateway;
import br.com.pagseguro.servicelayer.model.BillsModel;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
@Slf4j
public class GetBillPdfGatewayImpl implements BillsGateway {
    private final GetBillsClient client;

    @Override
    public BillsModel getBills(String customerId, String linkName, String status, int limit, int offset) {
        return client.getBoletoResource(customerId, linkName, status, limit, offset);
    }
}
