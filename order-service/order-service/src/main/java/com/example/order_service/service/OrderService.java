package com.example.order_service.service;

import com.example.order_service.entity.Order;
import com.example.order_service.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.order_service.client.ProductClient;
import com.example.order_service.client.UserClient;
import com.example.order_service.dto.ProductDTO;
import com.example.order_service.dto.UserDTO;
import java.util.List;

@Service
public class OrderService {
    @Autowired
    private OrderRepository repository;
    private ProductClient productClient;
    private UserClient userClient;

    public OrderService(OrderRepository repository, ProductClient productClient, UserClient userClient) {
        this.repository = repository;
        this.productClient = productClient;
        this.userClient = userClient;
    }

    public List<Order> findAll() {
        return repository.findAll();
    }

    public Order placeOrder(Order order) {
        // Fetch user and product info from other microservices
        UserDTO user = userClient.getUserById(order.getUserId());
        ProductDTO product = productClient.getProductById(order.getProductId());


        // Optional: Validate if user and product exist
        if (user == null) {
            throw new RuntimeException("User not found with ID: " + order.getUserId());
        }

        if (product == null) {
            throw new RuntimeException("Product not found with ID: " + order.getProductId());
        }

        // Calculate total price
        double totalPrice = product.getPrice() * order.getQuantity();
        order.setTotalPrice(totalPrice);

        // Save the order
        return repository.save(order);
    }
}
