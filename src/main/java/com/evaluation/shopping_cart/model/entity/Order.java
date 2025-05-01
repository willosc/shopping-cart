package com.evaluation.shopping_cart.model.entity;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class Order {
    private String id;
    private LocalDateTime createdAt;
    private List<OrderItem> items;
    private Double total;
    private Customer customer;
}