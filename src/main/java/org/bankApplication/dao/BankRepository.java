package org.bankApplication.dao;

import org.bankApplication.model.BankBranch;
import org.bankApplication.model.Customer;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import static java.lang.Math.random;

@Repository
public class BankRepository {

    @Autowired
    private SessionFactory sessionFactory;

    public void saveBranch(BankBranch bankBranch) {


        sessionFactory.getCurrentSession().save(bankBranch);
    }

    public void saveBranchUser(BankBranch bankBranch) {

        ArrayList<Customer> customers= (ArrayList<Customer>) bankBranch.getCustomers();
        Iterator<Customer> it=customers.iterator();
        int i=0;
        String acc=String.valueOf(bankBranch.getBranchCode());
        while(it.hasNext())
        {
            Random rand = new Random();
            String random = String.format("%04d", rand.nextInt(10000));
            String account=acc+random;
            customers.get(i++).setAccountNumber(account);
            sessionFactory.getCurrentSession().save(bankBranch);
            if(i==customers.size())
                break;
        }


    }

    public void updateBranch(BankBranch bankBranch)
    {

        sessionFactory.getCurrentSession().update(bankBranch);

    }
    @SuppressWarnings("unchecked")
    public List<BankBranch> getAll()
    {
        try {
            List<BankBranch> details= sessionFactory.getCurrentSession().createQuery("from BankBranch").list();
            return details;
        }
        catch (Exception e)
        {
            return new ArrayList<>();
        }
    }

    public void deleteBranch(BankBranch bankBranch)
    {
        sessionFactory.getCurrentSession().delete(bankBranch);
    }

}
