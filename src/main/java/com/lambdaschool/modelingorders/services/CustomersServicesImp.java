package com.lambdaschool.modelingorders.services;

import com.lambdaschool.modelingorders.models.Customer;
import com.lambdaschool.modelingorders.repositories.CustomersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Transactional
@Service(value = "customerServices")
public class CustomersServicesImp implements CustomersServices{

    @Autowired
    private CustomersRepository customersRepository;

    @Transactional
    @Override
    public List<Customer> findAllOrders() {
        List<Customer> list = new ArrayList<>();
        customersRepository.findAll().iterator().forEachRemaining(list::add);
        return list;
    }
    @Transactional
    @Override
    public Customer findCustomerById(long customerid) {
        return customersRepository.findById(customerid)
                .orElseThrow(() -> new EntityNotFoundException("Customer" + customerid + "not Found."));

    }

    @Transactional
    @Override
    public Customer save(Customer customer) {
        Customer newCustomer = customer;
        
        return customersRepository.save(newCustomer);
    }

    @Transactional
    @Override
    public Customer update(Customer customer, long id) {
        return null;
    }

    @Transactional
    @Override
    public void delete(long id) {

    }

}
