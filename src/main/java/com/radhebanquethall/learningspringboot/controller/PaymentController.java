package com.radhebanquethall.learningspringboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.radhebanquethall.learningspringboot.dto.PaymentRequest;
import com.radhebanquethall.learningspringboot.dto.PaymentResponse;
import com.radhebanquethall.learningspringboot.service.PaymentService;

@RestController
@RequestMapping("/payments")
public class PaymentController {
	
	@Autowired
	PaymentService paymentService;
	
	@GetMapping("/{id}")
	public ResponseEntity<PaymentResponse> getPaymentById(@PathVariable Long id){
		
		PaymentRequest paymentRequest = new PaymentRequest();
		
		paymentRequest.setPaymentId(id);
		
		PaymentResponse paymentDetails = paymentService.getPaymentDetailsById(paymentRequest);
		
		return ResponseEntity.ok(paymentDetails);
		
	}
	
	
}
