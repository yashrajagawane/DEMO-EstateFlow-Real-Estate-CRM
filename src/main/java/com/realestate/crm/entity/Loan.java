package com.realestate.crm.entity;

import jakarta.persistence.*;

@Entity
public class Loan extends BaseEntity {
    @ManyToOne(optional=false) private Customer customer; private String bank; private double amount; private String status; private String reference;
    public Loan(){} public Loan(Customer c,String bank,double amount){customer=c;this.bank=bank;this.amount=amount;status="DOCUMENTS_PENDING";}
    public Customer getCustomer(){return customer;} public String getBank(){return bank;} public double getAmount(){return amount;} public String getStatus(){return status;} public String getReference(){return reference;}
    public void setCustomer(Customer v){customer=v;} public void setBank(String v){bank=v;} public void setAmount(double v){amount=v;} public void setStatus(String v){status=v;} public void setReference(String v){reference=v;}
}
