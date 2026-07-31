package com.realestate.crm.repository;
import com.realestate.crm.entity.*; import java.util.List; import org.springframework.data.jpa.repository.JpaRepository;
public interface CustomerRepository extends JpaRepository<Customer,Long>{ List<Customer> findByDeletedFalseOrderByCreatedAtDesc(); long countByDeletedFalse(); List<Customer> findByOwnerAndDeletedFalseOrderByCreatedAtDesc(User owner); }
