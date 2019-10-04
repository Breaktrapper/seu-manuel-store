package com.seumanuel.store.controller;


import com.seumanuel.store.model.Order;
import com.seumanuel.store.service.OrderService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
public class OrderController {
    private final OrderService service;

    public OrderController(OrderService service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    public Order findById(@PathVariable String id) {
        return service.findById(id);
    }

    @PostMapping
    public Order saveOrder (@RequestBody Order order) {
        return service.saveOrder(order);
    }

    @DeleteMapping("/{id}")
    public void deleteOrder (@PathVariable String id) {

        service.deleteOrder(id);
    }
}