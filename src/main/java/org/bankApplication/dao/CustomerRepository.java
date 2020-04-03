package org.bankApplication.dao;



import org.hibernate.SessionFactory;

import org.bankApplication.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomerRepository {

    @Autowired
    private SessionFactory sessionFactory;



    public void saveCustomer(Customer customer) {
        sessionFactory.getCurrentSession().save(customer);


    }


    public void deleteCustomer(Customer customer) {

        sessionFactory.getCurrentSession().delete(customer);
    }


    public void updateCustomer(Customer customer){

        sessionFactory.getCurrentSession().update(customer);
    }
    public void creditBalance(Customer customer){

        List<Customer> customer1=sessionFactory.getCurrentSession().createQuery("from Customer u where u.accountNumber = '"+customer.getAccountNumber()+"' ").list();
        double total=customer1.get(0).getBalance()+customer.getBalance();
        customer1.get(0).setBalance(total);
        sessionFactory.getCurrentSession().update(customer1.get(0));
    }
    public String debitBalance(Customer customer){

        List<Customer> customer1=sessionFactory.getCurrentSession().createQuery("from Customer u where u.accountNumber = '"+customer.getAccountNumber()+"' ").list();
        if(customer1.get(0).getBalance()<customer.getBalance())
            return"Low Balance";
        double total=customer1.get(0).getBalance()-customer.getBalance();
        customer1.get(0).setBalance(total);
        sessionFactory.getCurrentSession().update(customer1.get(0));
        return "Debited";
    }


}
