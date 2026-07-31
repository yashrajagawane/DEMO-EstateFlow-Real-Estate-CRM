package com.realestate.crm.repository;
import com.realestate.crm.entity.SupportTicket; import java.util.List; import org.springframework.data.jpa.repository.JpaRepository;
public interface SupportTicketRepository extends JpaRepository<SupportTicket,Long>{ List<SupportTicket> findByDeletedFalseOrderByCreatedAtDesc(); long countByStatusAndDeletedFalse(String status); }
