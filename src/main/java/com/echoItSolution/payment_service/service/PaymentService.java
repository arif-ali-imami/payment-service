package com.echoItSolution.payment_service.service;

import com.echoItSolution.payment_service.entity.Payment;
import com.echoItSolution.payment_service.repository.PaymentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.stereotype.Service;

import java.util.Random;
import java.util.UUID;

@RequiredArgsConstructor
@Service
@Slf4j
public class PaymentService {
    private final PaymentRepository paymentRepository;
    private final ServerProperties serverProperties;
    public Payment doPayment(Payment payment){
        payment.setPaymentStatus(paymentProcessing());
        payment.setTransactionId(UUID.randomUUID().toString());
        Integer port = serverProperties.getPort();
        log.info("Request servered by port :{}",port);
        return paymentRepository.save(payment);
    }

    private String paymentProcessing() {
        return new Random().nextBoolean()?"Success":"Failure";
    }
}
