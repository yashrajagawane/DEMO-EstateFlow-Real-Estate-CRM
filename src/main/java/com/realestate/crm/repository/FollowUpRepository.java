package com.realestate.crm.repository;
import com.realestate.crm.entity.*; import java.time.LocalDate; import java.util.List; import org.springframework.data.jpa.repository.JpaRepository;
public interface FollowUpRepository extends JpaRepository<FollowUp,Long>{ List<FollowUp> findByDeletedFalseOrderByDueDateAsc(); long countByDueDateAndCompletedFalseAndDeletedFalse(LocalDate date); }
