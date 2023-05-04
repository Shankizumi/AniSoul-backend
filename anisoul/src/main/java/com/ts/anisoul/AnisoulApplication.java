package com.ts.anisoul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@EntityScan(basePackages="com.dto")
@EnableJpaRepositories(basePackages="com.dao")
@SpringBootApplication(scanBasePackages="com")
@EnableAutoConfiguration(exclude = {org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class})

public class AnisoulApplication {

	public static void main(String[] args) {
		SpringApplication.run(AnisoulApplication.class, args);
		
	}

}
