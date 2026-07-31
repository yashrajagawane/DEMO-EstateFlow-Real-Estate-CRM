package com.realestate.crm.repository;
import com.realestate.crm.entity.*; import java.util.List; import org.springframework.data.jpa.repository.JpaRepository;
public interface PropertyRepository extends JpaRepository<Property,Long>{ List<Property> findByDeletedFalseOrderByCreatedAtDesc(); long countByStatusAndDeletedFalse(PropertyStatus status); }
