package com.realestate.crm.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class SupportTicket extends BaseEntity {
    @ManyToOne(optional=false) private Customer customer; private String subject; private String priority; private String status; private String description; private LocalDateTime resolvedAt;
    public SupportTicket(){} public SupportTicket(Customer c,String subject,String priority,String description){customer=c;this.subject=subject;this.priority=priority;this.description=description;status="OPEN";}
    public Customer getCustomer(){return customer;} public String getSubject(){return subject;} public String getPriority(){return priority;} public String getStatus(){return status;} public String getDescription(){return description;} public LocalDateTime getResolvedAt(){return resolvedAt;}
    public void setCustomer(Customer v){customer=v;} public void setSubject(String v){subject=v;} public void setPriority(String v){priority=v;} public void setStatus(String v){status=v;} public void setDescription(String v){description=v;} public void setResolvedAt(LocalDateTime v){resolvedAt=v;}
}
