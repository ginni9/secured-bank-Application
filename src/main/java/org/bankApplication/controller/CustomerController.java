package org.bankApplication.controller;

import org.bankApplication.model.Customer;
import org.bankApplication.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
public class CustomerController {

    @Autowired
    CustomerService customerService;


    @RequestMapping(value="/customer/saveCustomer",method = RequestMethod.POST)
    public String addCustomer(@RequestBody Customer customer)
    {
         customerService.saveCustomer(customer);
         return "Success";
    }

    @RequestMapping(value="/customer/deleteCustomer", method = RequestMethod.POST)
    public String deleteCustomer(@RequestBody Customer customer) {
        customerService.deleteCustomer(customer);
        return "Success";
    }



    @RequestMapping(value="/customer/updateCustomer", method = RequestMethod.POST)
    public String update(@RequestBody Customer customer)
    {
        customerService.updateCustomer(customer);
        return "Success";
    }

    @RequestMapping(value="/customer/creditBalance", method = RequestMethod.POST)
    public String addBalance(@RequestBody Customer customer)
    {
        customerService.creditBalance(customer);
        return "Credited";
    }
    @RequestMapping(value="/customer/debitBalance", method = RequestMethod.POST)
    public String retrieveBalance(@RequestBody Customer customer) {
        return customerService.debitBalance(customer);
    }



}
