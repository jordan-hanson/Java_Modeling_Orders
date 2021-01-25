package com.lambdaschool.modelingorders.services;

import com.lambdaschool.modelingorders.models.Customer;

import java.util.List;

public interface CustomersServices {

    List<Customer> findAllOrders();

    Customer findCustomerById(long customerid);

//    List<Customer> findByNameLike(String subname);

//    POST NEW CUSTOMER TO PUT IN A DATABASE
     Customer save(Customer customer);

//   PUT REPLACES AN EXISITING RESTAURANT WITH ALL NEW FIELD INFORMATION
//   PATCH UPDATES WHAT IS TAKEN IN TO UPDATE IN TEH OJECT WITH VALIDATED ID
    Customer update(Customer customer, long id);

//    DELETE
    void delete(long id);

}
