package com.realestate.crm.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class SiteVisit extends BaseEntity {
    @ManyToOne(optional=false) private Lead lead; @ManyToOne(optional=false) private Property property; private LocalDate visitDate; private String status; private String notes;
    public SiteVisit(){} public SiteVisit(Lead l,Property p,LocalDate d){lead=l;property=p;visitDate=d;status="SCHEDULED";}
    public Lead getLead(){return lead;} public Property getProperty(){return property;} public LocalDate getVisitDate(){return visitDate;} public String getStatus(){return status;} public String getNotes(){return notes;}
    public void setLead(Lead v){lead=v;} public void setProperty(Property v){property=v;} public void setVisitDate(LocalDate v){visitDate=v;} public void setStatus(String v){status=v;} public void setNotes(String v){notes=v;}
}
