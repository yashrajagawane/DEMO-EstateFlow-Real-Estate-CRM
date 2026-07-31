package com.realestate.crm.entity;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Vendor extends BaseEntity {
    @NotBlank private String name; private String service; private String phone; private String email; private double outstanding;
    public Vendor(){} public Vendor(String n,String s,String p,String e){name=n;service=s;phone=p;email=e;}
    public String getName(){return name;} public String getService(){return service;} public String getPhone(){return phone;} public String getEmail(){return email;} public double getOutstanding(){return outstanding;}
    public void setName(String v){name=v;} public void setService(String v){service=v;} public void setPhone(String v){phone=v;} public void setEmail(String v){email=v;} public void setOutstanding(double v){outstanding=v;}
}
