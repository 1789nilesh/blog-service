package com.blogging.blog_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class BlogServiceApplication {

	public static void main(String[] args) {
		System.out.println("starting blog-service");
		SpringApplication.run(BlogServiceApplication.class, args);
		System.out.println("blog-service is up");
	}

}
