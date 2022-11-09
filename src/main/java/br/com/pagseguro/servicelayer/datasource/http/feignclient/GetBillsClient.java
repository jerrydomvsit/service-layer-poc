package br.com.pagseguro.servicelayer.datasource.http.feignclient;


import br.com.pagseguro.servicelayer.model.BillsModel;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Component
@FeignClient(
        name = "GetBoletoResourceApi",
        url = "${app.integration.boleto-resource.url}")
@RateLimiter(name = "boletoResourceGet")
@CircuitBreaker(name = "boletoResourceGet")
public interface GetBillsClient {

    @RequestMapping(
            method = RequestMethod.GET,
            value="/customers/{customerId}/boletos?link_name={link_name}&status={status}&limit={limit}&offset={offset}"
    )
    BillsModel getBoletoResource(@PathVariable("customerId") String customerId,
                                 @PathVariable("link_name") String link_name,
                                 @PathVariable("status") String status,
                                 @PathVariable("limit") int limit,
                                 @PathVariable("offset") int offset);

}
