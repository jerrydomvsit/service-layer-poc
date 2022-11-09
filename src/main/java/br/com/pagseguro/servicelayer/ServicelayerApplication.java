package br.com.pagseguro.servicelayer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
@EnableConfigurationProperties
public class ServicelayerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServicelayerApplication.class, args);
	}

}
