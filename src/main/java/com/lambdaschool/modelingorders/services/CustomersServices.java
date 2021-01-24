package com.lambdaschool.modelingorders.services;

import com.lambdaschool.modelingorders.models.Customer;

import java.util.List;

public interface CustomersServices {
    Customer save(Customer customer);

    List<Customer> findAllOrders();

    Customer findCustomerById(long customerid);
}
