package com.realestate.crm.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Customer extends BaseEntity {
    @NotBlank private String name;
    @Email private String email;
    private String phone;
    private String address;
    @ManyToOne(fetch = FetchType.LAZY) private User owner;
    public Customer(){} public Customer(String name,String email,String phone,User owner){this.name=name;this.email=email;this.phone=phone;this.owner=owner;}
    public String getName(){return name;} public String getEmail(){return email;} public String getPhone(){return phone;} public String getAddress(){return address;} public User getOwner(){return owner;}
    public void setName(String v){name=v;} public void setEmail(String v){email=v;} public void setPhone(String v){phone=v;} public void setAddress(String v){address=v;} public void setOwner(User v){owner=v;}
}
