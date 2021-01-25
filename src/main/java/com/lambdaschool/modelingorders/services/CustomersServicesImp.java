package com.lambdaschool.modelingorders.services;

import com.lambdaschool.modelingorders.models.Customer;
import com.lambdaschool.modelingorders.models.Order;
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
        Customer newCustomer = new Customer();

        if(customer.getCustcode() !=0){
            customersRepository.findById(customer.getCustcode())
                    .orElseThrow(() -> new EntityNotFoundException("Customer " + customer.getCustcode() + " Not Found!"));
            newCustomer.setCustcode(customer.getCustcode());
        }

        newCustomer.setCustcity(customer.getCustcity());
        newCustomer.setCustcountry(customer.getCustcountry());
        newCustomer.setCustname(customer.getCustname());
        newCustomer.setWorkingarea(customer.getWorkingarea());
        newCustomer.setGrade(customer.getGrade());
        newCustomer.setOpeningamt(customer.getOpeningamt());
        newCustomer.setPaymentamt(customer.getPaymentamt());
        newCustomer.setPhone(customer.getPhone());
        newCustomer.setReceiveamt(customer.getReceiveamt());
        newCustomer.setOutstandingamt(customer.getOutstandingamt());

//        This is individual because if a customer is signing up under a referral link by that agent
//        Then it can just get the Agent. Only One agent per Customer but many orders.

        newCustomer.setAgent(customer.getAgent());

            newCustomer.getOrders().clear();
            for (Order o : customer.getOrders()) {
                Order newOrder = new Order();
                newOrder.setAdvanceamount(o.getAdvanceamount());
                newOrder.setOrdamount(o.getOrdamount());
                newOrder.setOrderdescription(o.getOrderdescription());

                newCustomer.getOrders().add(newOrder);
            }


        return customersRepository.save(newCustomer);
    }

    @Transactional
    @Override
    public Customer update(Customer customer, long id) {
        Customer updateCustomer = customersRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Customer " + id + "Not found.") );
        if (customer.getCustcity() !=null) updateCustomer.setCustcity(customer.getCustcity());
        if (customer.getCustcountry() !=null) updateCustomer.setCustcountry(customer.getCustcountry());
        if (customer.getCustname() !=null) updateCustomer.setCustname(customer.getCustname());
        if (customer.getWorkingarea() !=null) updateCustomer.setWorkingarea(customer.getWorkingarea());
        if (customer.getGrade() !=null) updateCustomer.setGrade(customer.getGrade());
        if (customer.hasValueForOpeningAmt) updateCustomer.setOpeningamt(customer.getOpeningamt());
        if (customer.hasValueForOutstandingAmt) updateCustomer.setOutstandingamt(customer.getOutstandingamt());
        if (customer.hasValueForPaymentAmt) updateCustomer.setPaymentamt(customer.getPaymentamt());
        if (customer.getPhone() !=null) updateCustomer.setPhone(customer.getPhone());
        if (customer.hasValueReceiveAmt) updateCustomer.setReceiveamt(customer.getReceiveamt());

        if(customer.getAgent() !=null ){
            updateCustomer.setAgent(customer.getAgent());
        }

        if(customer.getOrders().size() > 0){
            updateCustomer.getOrders().clear();

            for(Order o: customer.getOrders()){
                Order newOrder = new Order();
                newOrder.setOrderdescription(o.getOrderdescription());
                newOrder.setAdvanceamount(o.getAdvanceamount());
                newOrder.setOrdamount(o.getOrdamount());
                newOrder.setCustomer(updateCustomer);

                updateCustomer.getOrders().add(newOrder);
            }
        }

        return customersRepository.save(updateCustomer);
    }

    @Transactional
    @Override
    public void delete(long id) {

    }

}
