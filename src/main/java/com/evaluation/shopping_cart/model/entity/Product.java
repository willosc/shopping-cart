package com.evaluation.shopping_cart.model.entity;

import lombok.Data;

@Data
public class Product {
    private Long id;
    private String title;
    private String description;
    private Double price;
    private String category;
    private String image;
}
