package com.realestate.crm.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class FollowUp extends BaseEntity {
    @ManyToOne(optional=false) private Lead lead; private LocalDate dueDate; private String channel; private String notes; private boolean completed;
    public FollowUp(){} public FollowUp(Lead lead,LocalDate dueDate,String channel,String notes){this.lead=lead;this.dueDate=dueDate;this.channel=channel;this.notes=notes;}
    public Lead getLead(){return lead;} public LocalDate getDueDate(){return dueDate;} public String getChannel(){return channel;} public String getNotes(){return notes;} public boolean isCompleted(){return completed;}
    public void setLead(Lead v){lead=v;} public void setDueDate(LocalDate v){dueDate=v;} public void setChannel(String v){channel=v;} public void setNotes(String v){notes=v;} public void setCompleted(boolean v){completed=v;}
}
