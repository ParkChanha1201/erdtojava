package com.chcraft.erdtojava;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.chcraft.erdtojava", "com.chcraft.erd"})
public class ErdtojavaApplication {

	public static void main(String[] args) {
		SpringApplication.run(ErdtojavaApplication.class, args);
	}

}
