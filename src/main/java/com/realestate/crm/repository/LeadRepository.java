package com.realestate.crm.repository;
import com.realestate.crm.entity.*; import java.util.List; import org.springframework.data.jpa.repository.JpaRepository;
public interface LeadRepository extends JpaRepository<Lead,Long>{ List<Lead> findByDeletedFalseOrderByCreatedAtDesc(); long countByDeletedFalse(); long countByStatusAndDeletedFalse(LeadStatus status); List<Lead> findByAssignedToAndDeletedFalseOrderByCreatedAtDesc(User user); }
