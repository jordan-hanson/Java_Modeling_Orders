package com.lambdaschool.modelingorders.services;

import com.lambdaschool.modelingorders.models.Order;

import java.util.List;

public interface OrdersServices {
    Order save(Order order);

    List<Order> findAllOrders();
}
