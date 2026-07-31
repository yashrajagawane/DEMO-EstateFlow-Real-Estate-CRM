package com.realestate.crm.repository;
import com.realestate.crm.entity.User;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
public interface UserRepository extends JpaRepository<User,Long>{ Optional<User> findByUsernameAndDeletedFalse(String username); }
