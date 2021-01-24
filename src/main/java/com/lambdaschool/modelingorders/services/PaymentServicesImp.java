package com.lambdaschool.modelingorders.services;

import com.lambdaschool.modelingorders.models.Payment;
import com.lambdaschool.modelingorders.repositories.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Transactional
@Service(value= "paymentServices")
public class PaymentServicesImp implements PaymentServices{

    @Autowired
    private PaymentRepository paymentRepository;

    @Transactional
    @Override
    public Payment save(Payment payment) {
        return paymentRepository.save(payment);
    }
}
