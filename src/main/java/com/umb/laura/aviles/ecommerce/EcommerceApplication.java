package com.umb.laura.aviles.ecommerce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.umb.laura.aviles.ecommerce.utils.Cripto;

@SpringBootApplication
public class EcommerceApplication {

	public static void main(String[] args) {
		try {
			System.out.println(Cripto.encript("123456"));
		} catch (Exception e) {
			System.out.println("No se pudo encriptar");
		}
		SpringApplication.run(EcommerceApplication.class, args);
	}

}
