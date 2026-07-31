package com.realestate.crm.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.PositiveOrZero;
import java.time.LocalDate;

@Entity
public class Payment extends BaseEntity {
    @ManyToOne(optional=false) private Customer customer;
    @ManyToOne private Booking booking;
    @PositiveOrZero private double amount;
    private LocalDate paymentDate;
    private String method;
    private String reference;
    private boolean received;
    public Payment(){} public Payment(Customer c,double amount,String method){customer=c;this.amount=amount;this.method=method;paymentDate=LocalDate.now();received=true;}
    public Customer getCustomer(){return customer;} public Booking getBooking(){return booking;} public double getAmount(){return amount;} public LocalDate getPaymentDate(){return paymentDate;} public String getMethod(){return method;} public String getReference(){return reference;} public boolean isReceived(){return received;}
    public void setCustomer(Customer v){customer=v;} public void setBooking(Booking v){booking=v;} public void setAmount(double v){amount=v;} public void setPaymentDate(LocalDate v){paymentDate=v;} public void setMethod(String v){method=v;} public void setReference(String v){reference=v;} public void setReceived(boolean v){received=v;}
}
