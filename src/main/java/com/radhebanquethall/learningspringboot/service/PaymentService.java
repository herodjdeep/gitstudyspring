package com.radhebanquethall.learningspringboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.radhebanquethall.learningspringboot.dto.PaymentRequest;
import com.radhebanquethall.learningspringboot.dto.PaymentResponse;
import com.radhebanquethall.learningspringboot.entity.PaymentEntity;
import com.radhebanquethall.learningspringboot.repository.PaymentRepository;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    public PaymentResponse getPaymentDetailsById(PaymentRequest internalRequestObj) {
        Long paymentId = internalRequestObj.getPaymentId();
        PaymentEntity paymentModel = paymentRepository.getPaymentById(paymentId);
        
        if (paymentModel == null) {
            throw new RuntimeException("Payment not found");
        }
        
        return mapModelToResponseDTO(paymentModel);
    }

    private PaymentResponse mapModelToResponseDTO(PaymentEntity paymentEntity) {
        PaymentResponse response = new PaymentResponse();
        response.setPaymentId(paymentEntity.getId());
        response.setAmount(paymentEntity.getPaymentAmount());
        response.setCurrency(paymentEntity.getPaymentCurrency());
        response.setEmail(paymentEntity.getUserEmail());  // Include this if needed in the response
        return response;
    }
}
