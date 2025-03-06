package com.example.soap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SoapConsumerApplication {
//This is simple Calculator service which is implemented in SOAP.
//We are accessing this service in our REST service.
//SOAP service we have received one wsdl file. using wsdl file we are using their services.
	public static void main(String[] args) {
		SpringApplication.run(SoapConsumerApplication.class, args);
	}

}
