package com.seumanuel.store.service;

import  com.seumanuel.store.model.Order;

import com.seumanuel.store.model.OrderProduct;
import com.seumanuel.store.model.OrderStatus;
import com.seumanuel.store.repository.OrderRepository;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Order saveOrder (Order newOrder){
        return orderRepository.save(newOrder);
    }

    public Order findById (String id){
        return orderRepository.findById(id).orElse(null);
    }

    public void deleteOrder (String id){
        orderRepository.deleteById(id);
    }

    public Order confirmOrder (Order order){
        order.setStatus(OrderStatus.APPROVED);
        return orderRepository.save(order);
    }

    public Order deliveryOrder (Order order){
        order.setStatus(OrderStatus.DELIVERED);
        return orderRepository.save(order);
    }

   // public Order cancelOrder (Order order){
    //order.setStatus(new.OrderStatus);
    //}

}
