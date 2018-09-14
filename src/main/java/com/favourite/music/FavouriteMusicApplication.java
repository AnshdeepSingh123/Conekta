package com.favourite.music;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@SpringBootApplication
@EnableJpaAuditing
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class FavouriteMusicApplication {

	public static void main(String[] args) {
		SpringApplication.run(FavouriteMusicApplication.class, args);
	}
}
