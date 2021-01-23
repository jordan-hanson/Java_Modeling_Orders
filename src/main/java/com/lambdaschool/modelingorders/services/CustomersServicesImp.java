package com.lambdaschool.modelingorders.services;

import com.lambdaschool.modelingorders.models.Customer;
import com.lambdaschool.modelingorders.repositories.CustomersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service(value = "customerServices")
public class CustomersServicesImp implements CustomersServices{

    @Autowired
    private CustomersRepository customersRepository;

    @Transactional
    @Override
    public Customer save(Customer customer) {
        return customersRepository.save(customer);
    }
}
