package com.airtribe.library.management;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = "com.airtribe.library.management.*")
public class Application {


	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}


	@Bean
	public LibraryManagement libraryManagementService() {
		return new LibraryManagement();
	}
}
