package com.evaluation.shopping_cart.model;

import com.evaluation.shopping_cart.model.dto.CustomerDTO;
import lombok.Data;

import java.util.List;

@Data
public class OrderRequest {
    private List<Long> productIds;
    private CustomerDTO customer;
}
