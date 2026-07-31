package com.realestate.crm.service;

import com.realestate.crm.entity.*;
import com.realestate.crm.repository.*;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CrmService {
    public final UserRepository users; public final LeadRepository leads; public final PropertyRepository properties; public final CustomerRepository customers;
    public final BookingRepository bookings; public final PaymentRepository payments; public final EmployeeRepository employees; public final VendorRepository vendors;
    public final FollowUpRepository followUps; public final SiteVisitRepository siteVisits; public final LoanRepository loans; public final DocumentRepository documents;
    public final PettyCashRepository pettyCash; public final SupportTicketRepository supportTickets; public final AccountRepository accounts;
    public CrmService(UserRepository users,LeadRepository leads,PropertyRepository properties,CustomerRepository customers,BookingRepository bookings,PaymentRepository payments,EmployeeRepository employees,VendorRepository vendors,FollowUpRepository followUps,SiteVisitRepository siteVisits,LoanRepository loans,DocumentRepository documents,PettyCashRepository pettyCash,SupportTicketRepository supportTickets,AccountRepository accounts){this.users=users;this.leads=leads;this.properties=properties;this.customers=customers;this.bookings=bookings;this.payments=payments;this.employees=employees;this.vendors=vendors;this.followUps=followUps;this.siteVisits=siteVisits;this.loans=loans;this.documents=documents;this.pettyCash=pettyCash;this.supportTickets=supportTickets;this.accounts=accounts;}
    public List<Lead> leads(){return leads.findByDeletedFalseOrderByCreatedAtDesc();} public List<Property> properties(){return properties.findByDeletedFalseOrderByCreatedAtDesc();} public List<Customer> customers(){return customers.findByDeletedFalseOrderByCreatedAtDesc();}
    public List<Booking> bookings(){return bookings.findByDeletedFalseOrderByBookingDateDesc();} public List<Payment> payments(){return payments.findByDeletedFalseOrderByPaymentDateDesc();} public List<Employee> employees(){return employees.findByDeletedFalseOrderByNameAsc();} public List<Vendor> vendors(){return vendors.findByDeletedFalseOrderByNameAsc();}
    public List<FollowUp> followUps(){return followUps.findByDeletedFalseOrderByDueDateAsc();} public List<SiteVisit> siteVisits(){return siteVisits.findByDeletedFalseOrderByVisitDateDesc();} public List<Loan> loans(){return loans.findByDeletedFalseOrderByCreatedAtDesc();} public List<Document> documents(){return documents.findByDeletedFalseOrderByUploadedAtDesc();} public List<PettyCash> pettyCash(){return pettyCash.findByDeletedFalseOrderByTransactionDateDesc();} public List<SupportTicket> supportTickets(){return supportTickets.findByDeletedFalseOrderByCreatedAtDesc();} public List<Account> accounts(){return accounts.findByDeletedFalseOrderByTransactionDateDesc();}
    public <T extends BaseEntity> T softDelete(T entity){entity.setDeleted(true);return entity;}
}
