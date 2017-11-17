package com.springboot.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * SpringBootSwagger2Application class
 *
 * @author niezi
 * @date 2017/11/15
 */
@SpringBootApplication
@EntityScan(basePackages = {"com.springboot.demo.domain"})
@EnableJpaRepositories(basePackages = {"com.springboot.demo.repository"})
@EnableTransactionManagement
public class SpringBootSwagger2Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootSwagger2Application.class, args);
	}
}
