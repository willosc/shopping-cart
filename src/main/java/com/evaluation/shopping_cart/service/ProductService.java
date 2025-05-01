package com.evaluation.shopping_cart.service;

import com.evaluation.shopping_cart.interfaces.restclient.FakeStoreClient;
import com.evaluation.shopping_cart.model.entity.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final FakeStoreClient fakeStoreClient;

    public List<Product> getAllProducts() {
        return fakeStoreClient.getAllProducts();
    }

    public Product getProductById(Long id) {
        return fakeStoreClient.getProductById(id);
    }
}
