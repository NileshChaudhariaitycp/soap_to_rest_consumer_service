package com.example.soap.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.soap.service.CalculateService;

@Controller
public class Calculate {
	
	@Autowired
	private CalculateService calculateService;

	Logger log = LoggerFactory.getLogger(Calculate.class);
	@GetMapping("/dashboard")
	public String calculatorProfile()
	{
		return "dashboard-page";
	}
	
	@GetMapping("/add")
	public String addPage()
	{
		
		return "add-page";
	}
	
	@GetMapping("/addition")
	public String addition(@RequestParam(name = "firstNumber") int firstNumber, @RequestParam(name="secondNumber") int secondNumber,Model model) throws Exception
	{
		
		ResponseEntity<Integer> response = calculateService.add(firstNumber, secondNumber);
		HttpStatus httpStatus = (HttpStatus) response.getStatusCode();
	    int result  = response.getBody();
	    log.info("HTTP Status Response :"+httpStatus);
		log.info("Result For Addition Is :"+result);
		model.addAttribute("status", 200);
		model.addAttribute("firstNumber", firstNumber);
		model.addAttribute("secondNumber", secondNumber);
		model.addAttribute("response", httpStatus);
		model.addAttribute("result", result);
		return "add-page";
	}
	
	@GetMapping("/sub")
	public String subPage()
	{
		return "sub-page";
	}
	
	@GetMapping("/substraction")
	public String substraction(@RequestParam(name="firstNumber") int firstNumber, @RequestParam(name="secondNumber") int secondNumber,Model model) throws Exception
	{
		ResponseEntity<Integer> response = calculateService.subtract(firstNumber,secondNumber);
		HttpStatus httpStatus = (HttpStatus) response.getStatusCode();
		int result = response.getBody();
		log.info("HTTP Status Response :"+httpStatus);
		log.info("Result For Addition Is :"+result);
		model.addAttribute("status", 200);
		model.addAttribute("firstNumber", firstNumber);
		model.addAttribute("secondNumber", secondNumber);
		model.addAttribute("response", httpStatus);
		model.addAttribute("result", result);
		return "sub-page";
	}
	
	@GetMapping("/mul")
	public String mulPage()
	{
		return "multiply-page";
	}
	
	@GetMapping("/multiply")
	public String multiply(@RequestParam(name="firstNumber") int firstNumber, @RequestParam(name="secondNumber") int secondNumber,Model model) throws Exception
	{
		ResponseEntity<Integer> response = calculateService.multiply(firstNumber,secondNumber);
		HttpStatus httpStatus = (HttpStatus) response.getStatusCode();
		int result = response.getBody();
		log.info("HTTP Status Response :"+httpStatus);
		log.info("Result For Addition Is :"+result);
		model.addAttribute("status", 200);
		model.addAttribute("firstNumber", firstNumber);
		model.addAttribute("secondNumber", secondNumber);
		model.addAttribute("response", httpStatus);
		model.addAttribute("result", result);
		return "multiply-page";
	}
	
	@GetMapping("/div")
	public String divPage()
	{
		return "divide-page";
	}
	
	@GetMapping("/divide")
	public String divide(@RequestParam(name="firstNumber") int firstNumber, @RequestParam(name="secondNumber") int secondNumber,Model model) throws Exception
	{
		ResponseEntity<Integer> response = calculateService.divide(firstNumber,secondNumber);
		HttpStatus httpStatus = (HttpStatus) response.getStatusCode();
		int result = response.getBody();
		log.info("HTTP Status Response :"+httpStatus);
		log.info("Result For Addition Is :"+result);
		model.addAttribute("status", 200);
		model.addAttribute("firstNumber", firstNumber);
		model.addAttribute("secondNumber", secondNumber);
		model.addAttribute("response", httpStatus);
		model.addAttribute("result", result);
		return "divide-page";
	}
	
}
