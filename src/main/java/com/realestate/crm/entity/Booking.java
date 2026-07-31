package com.realestate.crm.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.PositiveOrZero;
import java.time.LocalDate;

@Entity
public class Booking extends BaseEntity {
    @ManyToOne(optional=false) private Customer customer;
    @ManyToOne(optional=false) private Property property;
    @ManyToOne private User salesExecutive;
    private LocalDate bookingDate;
    @PositiveOrZero private double amount;
    @Enumerated(EnumType.STRING) private BookingStatus status = BookingStatus.PENDING_APPROVAL;
    public Booking(){} public Booking(Customer c,Property p,User s,double amount){customer=c;property=p;salesExecutive=s;this.amount=amount;bookingDate=LocalDate.now();}
    public Customer getCustomer(){return customer;} public Property getProperty(){return property;} public User getSalesExecutive(){return salesExecutive;} public LocalDate getBookingDate(){return bookingDate;} public double getAmount(){return amount;} public BookingStatus getStatus(){return status;}
    public void setCustomer(Customer v){customer=v;} public void setProperty(Property v){property=v;} public void setSalesExecutive(User v){salesExecutive=v;} public void setBookingDate(LocalDate v){bookingDate=v;} public void setAmount(double v){amount=v;} public void setStatus(BookingStatus v){status=v;}
}
