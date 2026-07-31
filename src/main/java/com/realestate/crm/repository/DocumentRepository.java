package com.realestate.crm.repository;
import com.realestate.crm.entity.Document; import java.util.List; import org.springframework.data.jpa.repository.JpaRepository;
public interface DocumentRepository extends JpaRepository<Document,Long>{ List<Document> findByDeletedFalseOrderByUploadedAtDesc(); }
