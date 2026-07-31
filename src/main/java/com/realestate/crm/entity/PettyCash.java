package com.realestate.crm.entity;

import jakarta.persistence.Entity;
import java.time.LocalDate;

@Entity
public class PettyCash extends BaseEntity {
    private String category; private String description; private double amount; private LocalDate transactionDate; private String type;
    public PettyCash(){} public PettyCash(String category,String description,double amount,String type){this.category=category;this.description=description;this.amount=amount;this.type=type;transactionDate=LocalDate.now();}
    public String getCategory(){return category;} public String getDescription(){return description;} public double getAmount(){return amount;} public LocalDate getTransactionDate(){return transactionDate;} public String getType(){return type;}
    public void setCategory(String v){category=v;} public void setDescription(String v){description=v;} public void setAmount(double v){amount=v;} public void setTransactionDate(LocalDate v){transactionDate=v;} public void setType(String v){type=v;}
}
