package com.realestate.crm.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Document extends BaseEntity {
    @ManyToOne(optional=false) private Customer customer; private String name; private String documentType; private String fileName; private String filePath; private boolean verified; private LocalDateTime uploadedAt;
    public Document(){} public Document(Customer c,String name,String type){customer=c;this.name=name;documentType=type;uploadedAt=LocalDateTime.now();}
    public Customer getCustomer(){return customer;} public String getName(){return name;} public String getDocumentType(){return documentType;} public String getFileName(){return fileName;} public String getFilePath(){return filePath;} public boolean isVerified(){return verified;} public LocalDateTime getUploadedAt(){return uploadedAt;}
    public void setCustomer(Customer v){customer=v;} public void setName(String v){name=v;} public void setDocumentType(String v){documentType=v;} public void setFileName(String v){fileName=v;} public void setFilePath(String v){filePath=v;} public void setVerified(boolean v){verified=v;}
}
