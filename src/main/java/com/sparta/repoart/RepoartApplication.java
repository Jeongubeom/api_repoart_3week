package com.sparta.repoart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
@EnableJpaAuditing
@SpringBootApplication
public class RepoartApplication {

	public static void main(String[] args) {
		SpringApplication.run(RepoartApplication.class, args);
	}

}
