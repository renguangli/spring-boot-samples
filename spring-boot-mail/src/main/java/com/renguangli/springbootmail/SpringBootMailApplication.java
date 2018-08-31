package com.renguangli.springbootmail;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class SpringBootMailApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootMailApplication.class, args);
	}
}
