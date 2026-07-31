package com.realestate.crm.repository;
import com.realestate.crm.entity.PettyCash; import java.util.List; import org.springframework.data.jpa.repository.JpaRepository;
public interface PettyCashRepository extends JpaRepository<PettyCash,Long>{ List<PettyCash> findByDeletedFalseOrderByTransactionDateDesc(); }
