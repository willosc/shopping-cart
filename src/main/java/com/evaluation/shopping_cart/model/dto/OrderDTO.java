package com.evaluation.shopping_cart.model.dto;

import lombok.Data;

import java.util.List;

@Data
public class OrderDTO {
    private String id;
    private Double total;
    private List<?> items;
}
