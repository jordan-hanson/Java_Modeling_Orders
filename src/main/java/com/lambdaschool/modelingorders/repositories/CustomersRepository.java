package com.lambdaschool.modelingorders.repositories;

import com.lambdaschool.modelingorders.models.Customer;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CustomersRepository extends CrudRepository<Customer, Long> {

}
