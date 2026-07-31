package com.realestate.crm.repository;
import com.realestate.crm.entity.*; import java.util.List; import org.springframework.data.jpa.repository.JpaRepository;
public interface BookingRepository extends JpaRepository<Booking,Long>{ List<Booking> findByDeletedFalseOrderByBookingDateDesc(); long countByDeletedFalse(); List<Booking> findBySalesExecutiveAndDeletedFalseOrderByBookingDateDesc(User user); }
