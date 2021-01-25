package com.lambdaschool.modelingorders.controllers;

import com.lambdaschool.modelingorders.models.Customer;
import com.lambdaschool.modelingorders.services.CustomersServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/customers")
public class CustomerController {

    @Autowired
    private CustomersServices customersServices;

    @GetMapping(value = "/customer", produces = "application/json")
    public ResponseEntity<?> findAllOrders(){
        List<Customer> customerOrderList = customersServices.findAllOrders();
        return new ResponseEntity<>(customerOrderList, HttpStatus.OK);
    }
    @GetMapping(value = "/customer/{customerid}", produces = "application/json")
    public ResponseEntity<?> findAllById(@PathVariable long customerid){
        Customer customer = customersServices.findCustomerById(customerid);
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }
//    @GetMapping(value = "/customers/likename/{subname}", produces = "application/json")
//    public ResponseEntity<?> findByNameLike(@PathVariable String subname){
//        List<Customer> list = customersServices.findByNameLike(subname);
//        return new ResponseEntity<>(list, HttpStatus.OK);
//    }

    @PostMapping(value = "/customer", consumes = "application/json", produces = "application/json")
    public ResponseEntity<?> newCustomer(@Valid @RequestBody Customer newCustomer){
        newCustomer.setCustcode(0);
        newCustomer = customersServices.save(newCustomer);
        HttpHeaders responseHeaders = new HttpHeaders();
        URI newCustomerURI = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("{customerid}")
                .buildAndExpand(newCustomer.getCustcode())
                .toUri();
        responseHeaders.setLocation(newCustomerURI);
        return new ResponseEntity<>(newCustomer, responseHeaders, HttpStatus.CREATED);
    }
    @PutMapping(value = "/customer/{customerid}", consumes = "application/json", produces = "application/json")
    public ResponseEntity<?> replaceCustomerById(@PathVariable long customerid, @Valid @RequestBody Customer replaceInCustomer){
        replaceInCustomer.setCustcode(customerid);
        Customer customer = customersServices.save(replaceInCustomer);

        return new ResponseEntity<>(customer, HttpStatus.OK);
    }
    @PatchMapping(value ="/customer/{customerid}", consumes ="application/json", produces = "application/json")
    public ResponseEntity<?> updateCustomerById(@PathVariable long customerid, @Valid @RequestBody Customer updateCustomer){
        customersServices.update(updateCustomer, customerid);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @DeleteMapping(value = "/customer/{customerid}")
    public ResponseEntity<?> deleteCustomerById(@PathVariable long customerid){
        customersServices.delete(customerid);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
