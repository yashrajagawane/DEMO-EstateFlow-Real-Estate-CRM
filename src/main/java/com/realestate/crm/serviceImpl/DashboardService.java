package com.realestate.crm.serviceImpl;

import com.realestate.crm.entity.*;
import com.realestate.crm.service.CrmService;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.LinkedHashMap;
import java.util.Map;

@Service
public class DashboardService {
    private final CrmService crm;
    public DashboardService(CrmService crm){this.crm=crm;}
    public Map<String,Object> metrics(User user){
        Map<String,Object> m=new LinkedHashMap<>();
        boolean sales=user.getRole()==Role.SALES_EXECUTIVE;
        m.put("leads", sales?crm.leads.findByAssignedToAndDeletedFalseOrderByCreatedAtDesc(user).size():crm.leads.countByDeletedFalse());
        m.put("customers", sales?crm.customers.findByOwnerAndDeletedFalseOrderByCreatedAtDesc(user).size():crm.customers.countByDeletedFalse());
        m.put("properties",crm.properties.countByStatusAndDeletedFalse(PropertyStatus.AVAILABLE));
        m.put("bookings", sales?crm.bookings.findBySalesExecutiveAndDeletedFalseOrderByBookingDateDesc(user).size():crm.bookings.countByDeletedFalse());
        m.put("revenue",crm.payments.sumAmountByReceivedAndDeletedFalse(true));
        m.put("pendingPayments",crm.payments.countByReceivedAndDeletedFalse(false));
        m.put("employees",crm.employees.countByActiveAndDeletedFalse(true));
        m.put("vendors",crm.vendors.countByDeletedFalse());
        m.put("followUps",crm.followUps.countByDueDateAndCompletedFalseAndDeletedFalse(LocalDate.now()));
        m.put("openTickets",crm.supportTickets.countByStatusAndDeletedFalse("OPEN"));
        m.put("loanPending",crm.loans.countByStatusAndDeletedFalse("DOCUMENTS_PENDING"));
        return m;
    }
}
