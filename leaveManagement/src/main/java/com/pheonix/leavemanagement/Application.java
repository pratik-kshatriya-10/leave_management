package com.pheonix.leavemanagement;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.pheonix.leavemanagement.daos")
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
