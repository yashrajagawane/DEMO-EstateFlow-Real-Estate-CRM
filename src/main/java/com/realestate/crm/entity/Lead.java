package com.realestate.crm.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import java.time.LocalDate;

@Entity
public class Lead extends BaseEntity {
    @NotBlank private String name;
    @Email private String email;
    private String phone;
    private String source;
    @Enumerated(EnumType.STRING) @Column(nullable = false)
    private LeadStatus status = LeadStatus.NEW;
    private LocalDate nextFollowUp;
    @ManyToOne(fetch = FetchType.LAZY) private User assignedTo;

    public Lead() { }
    public Lead(String name, String email, String phone, String source, User assignedTo) { this.name=name; this.email=email; this.phone=phone; this.source=source; this.assignedTo=assignedTo; }
    public String getName(){return name;} public String getEmail(){return email;} public String getPhone(){return phone;} public String getSource(){return source;}
    public LeadStatus getStatus(){return status;} public LocalDate getNextFollowUp(){return nextFollowUp;} public User getAssignedTo(){return assignedTo;}
    public void setName(String v){name=v;} public void setEmail(String v){email=v;} public void setPhone(String v){phone=v;} public void setSource(String v){source=v;} public void setStatus(LeadStatus v){status=v;} public void setNextFollowUp(LocalDate v){nextFollowUp=v;} public void setAssignedTo(User v){assignedTo=v;}
}
