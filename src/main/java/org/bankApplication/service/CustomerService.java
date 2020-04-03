
package org.bankApplication.service;

import org.bankApplication.dao.CustomerRepository;
import org.bankApplication.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;


@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Transactional
    public void saveCustomer(Customer customer) {


        customerRepository.saveCustomer(customer);
    }

    @Transactional
    public void deleteCustomer(Customer customer) {
        customerRepository.deleteCustomer(customer);
    }



    @Transactional
    public void updateCustomer(Customer customer){
        customerRepository.updateCustomer(customer);
    }

    @Transactional
    public void creditBalance(Customer customer){
        customerRepository.creditBalance(customer);
    }

    @Transactional
    public String debitBalance(Customer customer){
       return customerRepository.debitBalance(customer);
    }


}
