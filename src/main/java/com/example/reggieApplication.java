package com.example;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class reggieApplication {

	public static void main(String[] args) {

		SpringApplication.run(reggieApplication.class, args);
		log.info("项目启动成功...");
	}

}
