package com.example.SpringProjectTemplate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class SpringProjectTemplateApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringProjectTemplateApplication.class, args);
	}

}
