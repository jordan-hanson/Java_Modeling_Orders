package com.lambdaschool.modelingorders.repositories;

import com.lambdaschool.modelingorders.models.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomersRepository extends CrudRepository<Customer, Long> {
}
