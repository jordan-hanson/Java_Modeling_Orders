package com.lambdaschool.modelingorders.services;

import com.lambdaschool.modelingorders.models.Order;
import com.lambdaschool.modelingorders.repositories.OrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;


@Transactional
@Service(value = "orderServices")
public class OrdersServicesImp implements OrdersServices{

    @Autowired
    private OrdersRepository ordersRepository;

    @Transactional
    @Override
    public Order save(Order order) {
        return ordersRepository.save(order) ;
    }

    @Override
    public List<Order> findAllOrders() {
        List<Order> list = new ArrayList<>();
        ordersRepository.findAll().iterator().forEachRemaining(list::add);
        return list;
    }

    @Override
    public Order findCustomerById(long orderid) {
        return ordersRepository.findById(orderid)
                .orElseThrow(()-> new EntityNotFoundException("Order " + orderid + "Not Found."));
    }
}
