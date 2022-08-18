package com.bbletscode.rotativo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

// TODO Utilizar Cache nas chamadas mais utilizadas ou complexas.

@SpringBootApplication
@EnableFeignClients
public class RotativoApplication {

	public static void main(String[] args) {
		SpringApplication.run(RotativoApplication.class, args);
	}

}
