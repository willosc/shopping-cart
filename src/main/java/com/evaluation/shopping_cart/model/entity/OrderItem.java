package com.evaluation.shopping_cart.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class OrderItem {
    private Long productId;
    private String productName;
    private Double productPrice;
}
