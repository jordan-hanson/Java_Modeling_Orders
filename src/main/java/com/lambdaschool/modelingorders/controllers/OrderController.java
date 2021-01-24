package com.lambdaschool.modelingorders.controllers;

import com.lambdaschool.modelingorders.models.Customer;
import com.lambdaschool.modelingorders.models.Order;
import com.lambdaschool.modelingorders.services.OrdersServices;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


@RestController
public class OrderController {

    @Autowired
    private OrdersServices ordersServices;

    @GetMapping(value = "/order/orders", produces = "application/json")
    public ResponseEntity<?> findAllOrders() {
        List<Order> orderList = ordersServices.findAllOrders();
        return new ResponseEntity<>(orderList, HttpStatus.OK);
    }
    @GetMapping(value = "/order/orders/{orderid}", produces = "application/json")
    public ResponseEntity<?> findAllById(@PathVariable long orderid) {
        Order order = ordersServices.findCustomerById(orderid);
        return new ResponseEntity<>(order, HttpStatus.OK);
    }
}
