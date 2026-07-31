package com.realestate.crm.repository;
import com.realestate.crm.entity.*; import java.util.List; import org.springframework.data.jpa.repository.*; import org.springframework.data.repository.query.Param;
public interface PaymentRepository extends JpaRepository<Payment,Long>{ List<Payment> findByDeletedFalseOrderByPaymentDateDesc(); @Query("select coalesce(sum(p.amount),0) from Payment p where p.received = :received and p.deleted = false") double sumAmountByReceivedAndDeletedFalse(@Param("received") boolean received); long countByReceivedAndDeletedFalse(boolean received); }
