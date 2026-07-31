package com.realestate.crm.config;

import com.realestate.crm.entity.*;
import com.realestate.crm.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;
import java.time.LocalDate;

@Configuration
public class DataInitializer {
    @Bean CommandLineRunner seed(UserRepository users, LeadRepository leads, PropertyRepository properties, CustomerRepository customers, BookingRepository bookings, PaymentRepository payments, EmployeeRepository employees, VendorRepository vendors, FollowUpRepository followUps, SiteVisitRepository visits, LoanRepository loans, DocumentRepository documents, PettyCashRepository pettyCash, SupportTicketRepository tickets, AccountRepository accounts, PasswordEncoder encoder){
        return args -> {
            if(users.count()>0)return;
            User admin=users.save(new User("admin",encoder.encode("admin123"),"Aarav Mehta",Role.ADMIN));
            User sales=users.save(new User("sales1",encoder.encode("sales123"),"Priya Sharma",Role.SALES_EXECUTIVE));
            User accountant=users.save(new User("accounts1",encoder.encode("accounts123"),"Rohan Iyer",Role.ACCOUNTANT));
            User hr=users.save(new User("hr1",encoder.encode("hr123"),"Neha Kapoor",Role.HR));
            User manager=users.save(new User("manager1",encoder.encode("manager123"),"Vikram Singh",Role.MANAGER));
            Property p1=properties.save(new Property("SKY-101","Skyline Residency","Whitefield, Bengaluru","Apartment",7850000,3));
            Property p2=properties.save(new Property("GRE-204","Greenview Villas","Sarjapur, Bengaluru","Villa",12400000,4));
            Property p3=properties.save(new Property("HAR-302","Harbor Heights","Worli, Mumbai","Apartment",21500000,3));
            Lead l1=leads.save(new Lead("Ananya Rao","ananya@example.com","+91 98765 00001","Website",sales));l1.setStatus(LeadStatus.QUALIFIED);leads.save(l1);
            Lead l2=leads.save(new Lead("Karan Malhotra","karan@example.com","+91 98765 00002","Referral",sales));
            Customer c1=customers.save(new Customer("Ananya Rao","ananya@example.com","+91 98765 00001",sales));
            Customer c2=customers.save(new Customer("Meera Joshi","meera@example.com","+91 98765 00003",sales));
            employees.save(new Employee("Sanjay Nair","Sales","Sales Manager","sanjay@estatecrm.local",98000));
            employees.save(new Employee("Divya Menon","Finance","Senior Accountant","divya@estatecrm.local",85000));
            employees.save(new Employee("Arjun Bhat","Operations","Site Coordinator","arjun@estatecrm.local",62000));
            vendors.save(new Vendor("UrbanBuild Contractors","Civil & Maintenance","+91 98765 11111","hello@urbanbuild.local"));
            vendors.save(new Vendor("BrightSpace Interiors","Interior Design","+91 98765 11112","contact@brightspace.local"));
            followUps.save(new FollowUp(l1,LocalDate.now(),"CALL","Confirm preferred floor and budget."));
            followUps.save(new FollowUp(l2,LocalDate.now().plusDays(2),"EMAIL","Send villa brochure."));
            visits.save(new SiteVisit(l1,p1,LocalDate.now().plusDays(1)));
            Booking b=bookings.save(new Booking(c1,p1,sales,785000));b.setStatus(BookingStatus.APPROVED);bookings.save(b);
            payments.save(new Payment(c1,500000,"Bank Transfer"));
            Payment pending=new Payment(c2,350000,"Cheque");pending.setReceived(false);payments.save(pending);
            loans.save(new Loan(c1,"HDFC Home Loans",5500000));
            Document doc=documents.save(new Document(c1,"PAN Card","IDENTITY"));doc.setVerified(true);documents.save(doc);
            pettyCash.save(new PettyCash("Office","Stationery and printing",4200,"EXPENSE"));
            pettyCash.save(new PettyCash("Travel","Site visit transport",7800,"EXPENSE"));
            tickets.save(new SupportTicket(c1,"Handover schedule","HIGH","Customer requested an updated handover timeline."));
            accounts.save(new Account("Booking Revenue","SALES",0,785000,"BK-1001"));
            accounts.save(new Account("Office Expenses","OPERATIONS",12000,0,"EXP-1007"));
        };
    }
}
