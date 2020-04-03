package org.bankApplication.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Table(name = "BankBranch")
public class BankBranch {

    @Id
    private int branchCode;

    private String branchName;


    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name="bankBranch")
    private Collection<Customer> customers;

    public BankBranch()
    {

    }

    public BankBranch(int branchCode, String branchName) {
        this.branchCode = branchCode;
        this.branchName = branchName;
    }

    public Collection<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(Collection<Customer> customers) {
        this.customers = customers;
    }

    public int getBranchCode() {
        return branchCode;
    }

    public void setBranchCode(int branchCode) {
        this.branchCode = branchCode;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    @Override
    public String toString() {
        return "BankBranch{" +
                "branchCode=" + branchCode +
                ", branchName='" + branchName + '\'' +
                '}';
    }
}
