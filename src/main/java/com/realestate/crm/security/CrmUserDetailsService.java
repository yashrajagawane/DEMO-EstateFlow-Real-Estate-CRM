package com.realestate.crm.security;

import com.realestate.crm.repository.UserRepository;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;

@Service
public class CrmUserDetailsService implements UserDetailsService {
    private final UserRepository users;
    public CrmUserDetailsService(UserRepository users){this.users=users;}
    @Override public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return users.findByUsernameAndDeletedFalse(username).map(AppUserDetails::new).orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }
}
