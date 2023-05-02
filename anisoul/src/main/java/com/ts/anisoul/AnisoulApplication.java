package com.ts.anisoul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@EntityScan(basePackages="com.dto")
@EnableJpaRepositories(basePackages="com.dao")
@SpringBootApplication(scanBasePackages="com")

public class AnisoulApplication {

	public static void main(String[] args) {
		SpringApplication.run(AnisoulApplication.class, args);
		
	}

}
