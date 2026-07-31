package com.realestate.crm.repository;
import com.realestate.crm.entity.Vendor; import java.util.List; import org.springframework.data.jpa.repository.JpaRepository;
public interface VendorRepository extends JpaRepository<Vendor,Long>{ List<Vendor> findByDeletedFalseOrderByNameAsc(); long countByDeletedFalse(); }
