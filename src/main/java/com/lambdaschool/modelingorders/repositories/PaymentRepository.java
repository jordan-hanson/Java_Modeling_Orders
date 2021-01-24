package com.lambdaschool.modelingorders.repositories;

import com.lambdaschool.modelingorders.models.Payment;
import org.springframework.data.repository.CrudRepository;

public interface PaymentRepository extends CrudRepository<Payment, Long> {
}
