package com.realestate.crm.controller;

import com.realestate.crm.entity.*;
import com.realestate.crm.security.AppUserDetails;
import com.realestate.crm.service.CrmService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.nio.file.*;
import java.time.LocalDate;
import java.util.List;

@Controller
public class CrmController {
    private final CrmService crm; private final Path uploadRoot=Paths.get("uploads");
    public CrmController(CrmService crm){this.crm=crm;try{Files.createDirectories(uploadRoot);}catch(IOException ignored){}}
    private String page(Model m,String title,String active){m.addAttribute("pageTitle",title);m.addAttribute("activePage",active);return "module";}
    private void common(Model m){m.addAttribute("users",crm.users.findAll());m.addAttribute("leads",crm.leads());m.addAttribute("properties",crm.properties());m.addAttribute("customers",crm.customers());}

    @GetMapping({"/","/leads"}) public String leads(Model m){common(m);m.addAttribute("rows",crm.leads());m.addAttribute("module","leads");return page(m,"Lead Management","leads");}
    @PostMapping("/leads/save") public String saveLead(@RequestParam(required=false) Long id,@RequestParam String name,@RequestParam(required=false) String email,@RequestParam(required=false) String phone,@RequestParam(required=false) String source,@RequestParam(defaultValue="NEW") LeadStatus status,@RequestParam(required=false) LocalDate nextFollowUp,@RequestParam(required=false) Long assignedTo){Lead l=id==null?new Lead():crm.leads.findById(id).orElse(new Lead());l.setName(name);l.setEmail(email);l.setPhone(phone);l.setSource(source);l.setStatus(status);l.setNextFollowUp(nextFollowUp);if(assignedTo!=null)l.setAssignedTo(crm.users.findById(assignedTo).orElse(null));crm.leads.save(l);return "redirect:/leads?success=Lead+saved";}
    @PostMapping("/leads/delete/{id}") public String deleteLead(@PathVariable Long id){crm.leads.findById(id).ifPresent(x->{x.setDeleted(true);crm.leads.save(x);});return "redirect:/leads?success=Lead+archived";}

    @GetMapping("/properties") public String properties(Model m){common(m);m.addAttribute("rows",crm.properties());m.addAttribute("module","properties");return page(m,"Property Management","properties");}
    @PostMapping("/properties/save") public String saveProperty(@RequestParam(required=false) Long id,@RequestParam String code,@RequestParam String name,@RequestParam String location,@RequestParam String propertyType,@RequestParam double price,@RequestParam int bedrooms,@RequestParam(defaultValue="AVAILABLE") PropertyStatus status){Property p=id==null?new Property():crm.properties.findById(id).orElse(new Property());p.setCode(code);p.setName(name);p.setLocation(location);p.setPropertyType(propertyType);p.setPrice(price);p.setBedrooms(bedrooms);p.setStatus(status);crm.properties.save(p);return "redirect:/properties?success=Property+saved";}
    @PostMapping("/properties/delete/{id}") public String deleteProperty(@PathVariable Long id){crm.properties.findById(id).ifPresent(x->{x.setDeleted(true);crm.properties.save(x);});return "redirect:/properties?success=Property+archived";}

    @GetMapping("/customers") public String customers(Model m){common(m);m.addAttribute("rows",crm.customers());m.addAttribute("module","customers");return page(m,"Customer Management","customers");}
    @PostMapping("/customers/save") public String saveCustomer(@RequestParam(required=false) Long id,@RequestParam String name,@RequestParam(required=false) String email,@RequestParam(required=false) String phone,@RequestParam(required=false) String address,@RequestParam(required=false) Long owner){Customer c=id==null?new Customer():crm.customers.findById(id).orElse(new Customer());c.setName(name);c.setEmail(email);c.setPhone(phone);c.setAddress(address);if(owner!=null)c.setOwner(crm.users.findById(owner).orElse(null));crm.customers.save(c);return "redirect:/customers?success=Customer+saved";}
    @PostMapping("/customers/delete/{id}") public String deleteCustomer(@PathVariable Long id){crm.customers.findById(id).ifPresent(x->{x.setDeleted(true);crm.customers.save(x);});return "redirect:/customers?success=Customer+archived";}

    @GetMapping("/follow-ups") public String followUps(Model m){common(m);m.addAttribute("rows",crm.followUps());m.addAttribute("module","followups");return page(m,"Follow-up Management","follow-ups");}
    @PostMapping("/follow-ups/save") public String saveFollowUp(@RequestParam Long lead,@RequestParam LocalDate dueDate,@RequestParam String channel,@RequestParam(required=false) String notes,@RequestParam(defaultValue="false") boolean completed){crm.followUps.save(new FollowUp(crm.leads.findById(lead).orElseThrow(),dueDate,channel,notes));return "redirect:/follow-ups?success=Follow-up+scheduled";}

    @GetMapping("/site-visits") public String visits(Model m){common(m);m.addAttribute("rows",crm.siteVisits());m.addAttribute("module","visits");return page(m,"Site Visits","site-visits");}
    @PostMapping("/site-visits/save") public String saveVisit(@RequestParam Long lead,@RequestParam Long property,@RequestParam LocalDate visitDate,@RequestParam(defaultValue="SCHEDULED") String status,@RequestParam(required=false) String notes){SiteVisit v=new SiteVisit(crm.leads.findById(lead).orElseThrow(),crm.properties.findById(property).orElseThrow(),visitDate);v.setStatus(status);v.setNotes(notes);crm.siteVisits.save(v);return "redirect:/site-visits?success=Site+visit+scheduled";}

    @GetMapping("/bookings") public String bookings(Model m){common(m);m.addAttribute("rows",crm.bookings());m.addAttribute("module","bookings");return page(m,"Booking Management","bookings");}
    @PostMapping("/bookings/save") public String saveBooking(@RequestParam Long customer,@RequestParam Long property,@RequestParam double amount,@RequestParam(required=false) Long salesExecutive){User sales=salesExecutive==null?null:crm.users.findById(salesExecutive).orElse(null);crm.bookings.save(new Booking(crm.customers.findById(customer).orElseThrow(),crm.properties.findById(property).orElseThrow(),sales,amount));return "redirect:/bookings?success=Booking+submitted";}
    @PostMapping("/bookings/approve/{id}") public String approveBooking(@PathVariable Long id){crm.bookings.findById(id).ifPresent(b->{b.setStatus(BookingStatus.APPROVED);b.getProperty().setStatus(PropertyStatus.RESERVED);crm.bookings.save(b);crm.properties.save(b.getProperty());});return "redirect:/bookings?success=Booking+approved";}

    @GetMapping("/payments") public String payments(Model m){common(m);m.addAttribute("rows",crm.payments());m.addAttribute("module","payments");return page(m,"Payment Tracking","payments");}
    @PostMapping("/payments/save") public String savePayment(@RequestParam Long customer,@RequestParam double amount,@RequestParam String method,@RequestParam(required=false) String reference,@RequestParam(defaultValue="true") boolean received){Payment p=new Payment(crm.customers.findById(customer).orElseThrow(),amount,method);p.setReference(reference);p.setReceived(received);crm.payments.save(p);return "redirect:/payments?success=Payment+recorded";}

    @GetMapping("/loans") public String loans(Model m){common(m);m.addAttribute("rows",crm.loans());m.addAttribute("module","loans");return page(m,"Loan Processing","loans");}
    @PostMapping("/loans/save") public String saveLoan(@RequestParam Long customer,@RequestParam String bank,@RequestParam double amount,@RequestParam(required=false) String reference){Loan l=new Loan(crm.customers.findById(customer).orElseThrow(),bank,amount);l.setReference(reference);crm.loans.save(l);return "redirect:/loans?success=Loan+application+created";}

    @GetMapping("/employees") public String employees(Model m){common(m);m.addAttribute("rows",crm.employees());m.addAttribute("module","employees");return page(m,"Employee Management","employees");}
    @PostMapping("/employees/save") public String saveEmployee(@RequestParam String name,@RequestParam String department,@RequestParam String designation,@RequestParam(required=false) String email,@RequestParam double salary){crm.employees.save(new Employee(name,department,designation,email,salary));return "redirect:/employees?success=Employee+saved";}

    @GetMapping("/vendors") public String vendors(Model m){common(m);m.addAttribute("rows",crm.vendors());m.addAttribute("module","vendors");return page(m,"Vendor Management","vendors");}
    @PostMapping("/vendors/save") public String saveVendor(@RequestParam String name,@RequestParam String service,@RequestParam(required=false) String phone,@RequestParam(required=false) String email){crm.vendors.save(new Vendor(name,service,phone,email));return "redirect:/vendors?success=Vendor+saved";}

    @GetMapping("/petty-cash") public String pettyCash(Model m){common(m);m.addAttribute("rows",crm.pettyCash());m.addAttribute("module","pettycash");return page(m,"Petty Cash Management","petty-cash");}
    @PostMapping("/petty-cash/save") public String savePettyCash(@RequestParam String category,@RequestParam String description,@RequestParam double amount,@RequestParam(defaultValue="EXPENSE") String type){crm.pettyCash.save(new PettyCash(category,description,amount,type));return "redirect:/petty-cash?success=Expense+recorded";}

    @GetMapping("/accounts") public String accounts(Model m){common(m);m.addAttribute("rows",crm.accounts());m.addAttribute("module","accounts");return page(m,"Accounts & Finance","accounts");}
    @PostMapping("/accounts/save") public String saveAccount(@RequestParam String accountName,@RequestParam String category,@RequestParam double debit,@RequestParam double credit,@RequestParam(required=false) String reference){crm.accounts.save(new Account(accountName,category,debit,credit,reference));return "redirect:/accounts?success=Transaction+posted";}

    @GetMapping("/documents") public String documents(Model m){common(m);m.addAttribute("rows",crm.documents());m.addAttribute("module","documents");return page(m,"Customer Documents","documents");}
    @PostMapping("/documents/save") public String saveDocument(@RequestParam Long customer,@RequestParam String name,@RequestParam String documentType,@RequestParam(required=false) MultipartFile file) throws IOException {Document d=new Document(crm.customers.findById(customer).orElseThrow(),name,documentType);if(file!=null&&!file.isEmpty()){String safe=System.currentTimeMillis()+"-"+Path.of(file.getOriginalFilename()).getFileName();Path target=uploadRoot.resolve(safe);Files.copy(file.getInputStream(),target,StandardCopyOption.REPLACE_EXISTING);d.setFileName(file.getOriginalFilename());d.setFilePath(target.toString());}crm.documents.save(d);return "redirect:/documents?success=Document+uploaded";}

    @GetMapping("/support") public String support(Model m){common(m);m.addAttribute("rows",crm.supportTickets());m.addAttribute("module","support");return page(m,"Customer Support","support");}
    @PostMapping("/support/save") public String saveSupport(@RequestParam Long customer,@RequestParam String subject,@RequestParam String priority,@RequestParam String description){crm.supportTickets.save(new SupportTicket(crm.customers.findById(customer).orElseThrow(),subject,priority,description));return "redirect:/support?success=Ticket+created";}

    @GetMapping("/reports/leads.csv") @ResponseBody public String leadCsv(){StringBuilder b=new StringBuilder("Name,Email,Phone,Source,Status\n");for(Lead l:crm.leads())b.append(csv(l.getName())).append(',').append(csv(l.getEmail())).append(',').append(csv(l.getPhone())).append(',').append(csv(l.getSource())).append(',').append(l.getStatus()).append('\n');return b.toString();}
    private String csv(String value){return "\""+(value==null?"":value.replace("\"","\"\""))+"\"";}
}
