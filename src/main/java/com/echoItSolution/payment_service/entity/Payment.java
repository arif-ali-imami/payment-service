package com.echoItSolution.payment_service.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="payment")
public class Payment {
    @Id
    @GeneratedValue
    private Integer paymentId;
    private String paymentStatus;
    private String transactionId;
    private Integer orderId;
    private Double amount;
}