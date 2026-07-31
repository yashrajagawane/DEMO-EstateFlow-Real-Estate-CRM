package com.realestate.crm.repository;
import com.realestate.crm.entity.Employee; import java.util.List; import org.springframework.data.jpa.repository.JpaRepository;
public interface EmployeeRepository extends JpaRepository<Employee,Long>{ List<Employee> findByDeletedFalseOrderByNameAsc(); long countByActiveAndDeletedFalse(boolean active); }
