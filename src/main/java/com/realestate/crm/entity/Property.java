package com.realestate.crm.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;

@Entity
public class Property extends BaseEntity {
    @NotBlank @Column(nullable=false, unique=true) private String code;
    @NotBlank private String name;
    private String location;
    private String propertyType;
    @PositiveOrZero private double price;
    private int bedrooms;
    @Enumerated(EnumType.STRING) private PropertyStatus status = PropertyStatus.AVAILABLE;
    public Property() { }
    public Property(String code,String name,String location,String propertyType,double price,int bedrooms){this.code=code;this.name=name;this.location=location;this.propertyType=propertyType;this.price=price;this.bedrooms=bedrooms;}
    public String getCode(){return code;} public String getName(){return name;} public String getLocation(){return location;} public String getPropertyType(){return propertyType;} public double getPrice(){return price;} public int getBedrooms(){return bedrooms;} public PropertyStatus getStatus(){return status;}
    public void setCode(String v){code=v;} public void setName(String v){name=v;} public void setLocation(String v){location=v;} public void setPropertyType(String v){propertyType=v;} public void setPrice(double v){price=v;} public void setBedrooms(int v){bedrooms=v;} public void setStatus(PropertyStatus v){status=v;}
}
