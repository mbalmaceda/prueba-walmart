package com.walmart.lider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories(basePackages = "com.walmart.lider.repository")
public class SearchProductMsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SearchProductMsApplication.class, args);
	}

}
