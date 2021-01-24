package com.lambdaschool.modelingorders.controllers;

import com.lambdaschool.modelingorders.models.Customer;
import com.lambdaschool.modelingorders.services.CustomersServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/customers")
public class CustomerController {

    @Autowired
    private CustomersServices customersServices;

    @GetMapping(value = "/orders", produces = "application/json")
    public ResponseEntity<?> findAllOrders(){
        List<Customer> customerOrderList = customersServices.findAllOrders();
        return new ResponseEntity<>(customerOrderList, HttpStatus.OK);
    }
    @GetMapping(value = "/customer/{customerid}", produces = "application/json")
    public ResponseEntity<?> findAllById(@PathVariable long customerid){
        Customer customer = customersServices.findCustomerById(customerid);
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }
}
