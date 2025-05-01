package com.evaluation.shopping_cart.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PaymentResponse {
    private String orderId;
    private String paymentMethod;
    private PaymentStatus status;
    private String message;
}