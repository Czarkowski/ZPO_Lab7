package com.example.ZPO_Lab7.application;

import jakarta.persistence.Entity;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = "com.example.ZPO_Lab7.entity")
@EnableJpaRepositories(basePackages = "com.example.ZPO_Lab7.repository")
@ComponentScan(basePackages = "com.example.ZPO_Lab7")
public class ZpoLab7Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext run = SpringApplication.run(ZpoLab7Application.class, args);

	}

}
