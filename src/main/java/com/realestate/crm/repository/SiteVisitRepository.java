package com.realestate.crm.repository;
import com.realestate.crm.entity.SiteVisit; import java.util.List; import org.springframework.data.jpa.repository.JpaRepository;
public interface SiteVisitRepository extends JpaRepository<SiteVisit,Long>{ List<SiteVisit> findByDeletedFalseOrderByVisitDateDesc(); }
