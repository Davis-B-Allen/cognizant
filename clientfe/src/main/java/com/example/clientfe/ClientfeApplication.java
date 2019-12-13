package com.example.clientfe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients("com.example.clientfe.client")
public class ClientfeApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClientfeApplication.class, args);
	}

}
