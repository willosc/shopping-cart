package com.evaluation.shopping_cart.service;

import com.evaluation.shopping_cart.exception.NotFoundException;
import com.evaluation.shopping_cart.infrastructure.mapper.CustomerMapper;
import com.evaluation.shopping_cart.infrastructure.mapper.ProductMapper;
import com.evaluation.shopping_cart.model.dto.CustomerDTO;
import com.evaluation.shopping_cart.model.dto.ProductDTO;
import com.evaluation.shopping_cart.model.entity.Customer;
import com.evaluation.shopping_cart.model.entity.Order;
import com.evaluation.shopping_cart.model.entity.OrderItem;
import com.evaluation.shopping_cart.model.OrderRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final ProductService productService;
    private final ProductMapper productMapper;
    private final CustomerMapper customerMapper;
    private final Map<String, Order> orderRepo = new ConcurrentHashMap<>();

    public Order createOrder(OrderRequest request) {
        List<OrderItem> items = new ArrayList<>();
        double total = 0;

        for (Long productId : request.getProductIds()) {
            ProductDTO product = productMapper.toDTO(productService.getProductById(productId));
            items.add(new OrderItem(product.getId(), product.getTitle(), product.getPrice()));
            total += product.getPrice();
        }

        Order order = new Order();
        order.setId(UUID.randomUUID().toString());
        order.setCreatedAt(LocalDateTime.now());
        order.setItems(items);
        order.setTotal(total);

        if (request.getCustomer() != null) {
            Customer customer = customerMapper.fromDTO(request.getCustomer());
            customer.setId(UUID.randomUUID().toString());
            order.setCustomer(customer);
        }

        orderRepo.put(order.getId(), order);
        return order;
    }

    public List<Order> getAllOrders() {
        return new ArrayList<>(orderRepo.values());
    }

    public Order getOrderById(String id) {
        Order order = orderRepo.get(id);
        if (order == null) {
            throw new NotFoundException("Order with ID " + id + " not found");
        }
        return order;
    }
}