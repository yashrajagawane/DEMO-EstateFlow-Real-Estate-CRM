package com.realestate.crm.entity;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotBlank;
import java.time.LocalDate;

@Entity
public class Employee extends BaseEntity {
    @NotBlank private String name; private String department; private String designation; private String email; private LocalDate joiningDate; private double salary; private boolean active=true;
    public Employee(){} public Employee(String n,String d,String des,String email,double salary){name=n;department=d;designation=des;this.email=email;this.salary=salary;joiningDate=LocalDate.now();}
    public String getName(){return name;} public String getDepartment(){return department;} public String getDesignation(){return designation;} public String getEmail(){return email;} public LocalDate getJoiningDate(){return joiningDate;} public double getSalary(){return salary;} public boolean isActive(){return active;}
    public void setName(String v){name=v;} public void setDepartment(String v){department=v;} public void setDesignation(String v){designation=v;} public void setEmail(String v){email=v;} public void setJoiningDate(LocalDate v){joiningDate=v;} public void setSalary(double v){salary=v;} public void setActive(boolean v){active=v;}
}
