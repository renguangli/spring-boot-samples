package com.renguangli.oauth2client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class Oauth2clientApplication {

	public static void main(String[] args) {
		SpringApplication.run(Oauth2clientApplication.class, args);
	}

	@Bean("restTemplate")
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
}
