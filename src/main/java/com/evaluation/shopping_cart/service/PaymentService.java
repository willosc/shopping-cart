package com.evaluation.shopping_cart.service;

import com.evaluation.shopping_cart.infrastructure.mapper.OrderMapper;
import com.evaluation.shopping_cart.model.PaymentRequest;
import com.evaluation.shopping_cart.model.PaymentResponse;
import com.evaluation.shopping_cart.model.PaymentStatus;
import com.evaluation.shopping_cart.model.dto.OrderDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PaymentService {

    private final OrderService orderService;
    private final OrderMapper orderMapper;

    public PaymentResponse processPayment(PaymentRequest request) {
        try {
            OrderDTO order = orderMapper.toDTO(orderService.getOrderById(request.getOrderId()));

            // If successful
            return PaymentResponse.builder()
                    .orderId(order.getId())
                    .paymentMethod(request.getPaymentMethod())
                    .status(PaymentStatus.PAID)
                    .message("Payment successful for amount $" + order.getTotal())
                    .build();

        } catch (Exception e) {
            // If error
            return PaymentResponse.builder()
                    .orderId(request.getOrderId())
                    .paymentMethod(request.getPaymentMethod())
                    .status(PaymentStatus.FAILED)
                    .message("Payment failed: " + e.getMessage())
                    .build();
        }
    }
}