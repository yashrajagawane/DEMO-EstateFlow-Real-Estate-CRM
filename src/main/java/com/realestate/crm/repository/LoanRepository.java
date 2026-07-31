package com.realestate.crm.repository;
import com.realestate.crm.entity.Loan; import java.util.List; import org.springframework.data.jpa.repository.JpaRepository;
public interface LoanRepository extends JpaRepository<Loan,Long>{ List<Loan> findByDeletedFalseOrderByCreatedAtDesc(); long countByStatusAndDeletedFalse(String status); }
