package com.realestate.crm.entity;

import jakarta.persistence.Entity;
import java.time.LocalDate;

@Entity
public class Account extends BaseEntity {
    private String accountName; private String category; private double debit; private double credit; private LocalDate transactionDate; private String reference;
    public Account(){} public Account(String name,String category,double debit,double credit,String reference){accountName=name;this.category=category;this.debit=debit;this.credit=credit;this.reference=reference;transactionDate=LocalDate.now();}
    public String getAccountName(){return accountName;} public String getCategory(){return category;} public double getDebit(){return debit;} public double getCredit(){return credit;} public LocalDate getTransactionDate(){return transactionDate;} public String getReference(){return reference;}
    public void setAccountName(String v){accountName=v;} public void setCategory(String v){category=v;} public void setDebit(double v){debit=v;} public void setCredit(double v){credit=v;} public void setTransactionDate(LocalDate v){transactionDate=v;} public void setReference(String v){reference=v;}
}
