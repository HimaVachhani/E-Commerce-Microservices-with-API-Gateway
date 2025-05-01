package com.example.order_service.controller;

import com.example.order_service.entity.Order;
import com.example.order_service.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    private OrderService service;

    public OrderController(OrderService service) {
        this.service = service;
    }

    @GetMapping
    public List<Order> getAllOrders() {
        return service.findAll();
    }
    @PostMapping
        public ResponseEntity<Order> placeOrder(@RequestBody Order order) {
            Order savedOrder = service.placeOrder(order);
            return ResponseEntity.ok(savedOrder);
        }
    }

