package com.example.soap.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface CalculateService {

	ResponseEntity<Integer> add(int a,int b) throws Exception;

	ResponseEntity<Integer> subtract(int a, int b) throws Exception;

	ResponseEntity<Integer> multiply(int a, int b) throws Exception;

	ResponseEntity<Integer> divide(int firstNumber, int secondNumber) throws Exception;
	
}
