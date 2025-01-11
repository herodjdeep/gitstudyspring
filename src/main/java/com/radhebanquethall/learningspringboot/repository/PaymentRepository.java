package com.radhebanquethall.learningspringboot.repository;

import com.radhebanquethall.learningspringboot.entity.PaymentEntity;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class PaymentRepository {
    
    private final Map<Long, PaymentEntity> paymentData = new HashMap<>();

    // Constructor to add some sample data
    public PaymentRepository() {
        PaymentEntity payment1 = new PaymentEntity();
        payment1.setId(1L);
        payment1.setPaymentAmount(10000.00);
        payment1.setPaymentCurrency("INR");
        payment1.setUserEmail("djdeepakjaiswal1996@gmail.com");
        paymentData.put(1L, payment1);

        PaymentEntity payment2 = new PaymentEntity();
        payment2.setId(2L);
        payment2.setPaymentAmount(5000.00);
        payment2.setPaymentCurrency("USD");
        payment2.setUserEmail("example@domain.com");
        paymentData.put(2L, payment2);
    }

    public PaymentEntity getPaymentById(Long id) {
        return paymentData.get(id);
    }

    // You can add more methods to simulate CRUD operations if needed
}
