package com.example.soap.service;

import java.net.URL;

import javax.xml.namespace.QName;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.soap.soapcalculator.Calculator;
import com.example.soap.soapcalculator.CalculatorSoap;

@Service
public class CalculateServiceImpl implements CalculateService{
	
	private static final String clientUrl = "http://www.dneonline.com/calculator.asmx?wsdl";
	private static final String qName1 = "http://tempuri.org/";
	private static final String qName2 = "Calculator";
	
	private URL wsdlUrlProvider(String clientUrl) throws Exception 
	{
		URL wsdlUrl = new URL(clientUrl);
		return wsdlUrl;
	}
	
	private QName getQName(String qName1, String qName2)
	{
		QName qName = new QName(qName1,qName2);
		return qName;
	}
	
	private Calculator getService(URL wsdlUrl, QName qName)
	{
		Calculator service = new Calculator(wsdlUrl,qName);
		return service;
	}
	
	@Override
	public ResponseEntity<Integer> add(int a, int b) throws Exception 
	{
		
		URL wsdlUrl = wsdlUrlProvider(clientUrl); 
		QName qName = getQName(qName1,qName2); 
		Calculator service = getService(wsdlUrl,qName);
		CalculatorSoap soap = service.getCalculatorSoap();
		int result = soap.add(a, b);
		return ResponseEntity.ok(result);
	}

	@Override
	public ResponseEntity<Integer> subtract(int firstNumber, int secondNumber) throws Exception {
		
		URL wsdlUrl = wsdlUrlProvider(clientUrl);
		QName qName = getQName(qName1,qName2);
		Calculator service = getService(wsdlUrl,qName);
		CalculatorSoap soap  = service.getCalculatorSoap();
		int result = soap.subtract(firstNumber,secondNumber);
		return ResponseEntity.ok(result);
		
		
	}

	@Override
	public ResponseEntity<Integer> multiply(int a, int b) throws Exception {
		URL wsdlUrl = wsdlUrlProvider(clientUrl);
		QName qName = getQName(qName1,qName2);
		Calculator service = getService(wsdlUrl,qName);
		CalculatorSoap soap  = service.getCalculatorSoap();
		int result = soap.multiply(a,b);
		return ResponseEntity.ok(result);
	}

	@Override
	public ResponseEntity<Integer> divide(int a, int b) throws Exception {
		URL wsdlUrl = wsdlUrlProvider(clientUrl);
		QName qName = getQName(qName1,qName2);
		Calculator service = getService(wsdlUrl,qName);
		CalculatorSoap soap  = service.getCalculatorSoap();
		int result = soap.divide(a,b);
		return ResponseEntity.ok(result);
	}

}
