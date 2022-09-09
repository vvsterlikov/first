package com.example.first;

import com.example.first.reactor.Client;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@SpringBootApplication
@Slf4j
public class FirstApplication {

	public static void main(String[] args) {
		//SpringApplication.run(FirstApplication.class, args);
		Client c = new Client();
		c.start();

	}

}
