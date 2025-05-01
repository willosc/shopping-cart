package com.evaluation.shopping_cart.model;

import lombok.Data;

@Data
public class PaymentRequest {
    private String orderId;
    private String paymentMethod; // Simulation: "CREDIT_CARD", "PAYPAL", etc.
}
