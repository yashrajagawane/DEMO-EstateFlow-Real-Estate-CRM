package com.realestate.crm.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "users")
public class User extends BaseEntity {
    @NotBlank @Column(nullable = false, unique = true, length = 60)
    private String username;
    @Column(nullable = false)
    private String password;
    @NotBlank @Column(nullable = false)
    private String fullName;
    @Enumerated(EnumType.STRING) @Column(nullable = false, length = 30)
    private Role role;
    @Column(nullable = false)
    private boolean enabled = true;

    protected User() { }
    public User(String username, String password, String fullName, Role role) { this.username = username; this.password = password; this.fullName = fullName; this.role = role; }
    public String getUsername() { return username; }
    public String getPassword() { return password; }
    public String getFullName() { return fullName; }
    public Role getRole() { return role; }
    public boolean isEnabled() { return enabled; }
    public void setPassword(String password) { this.password = password; }
    public void setFullName(String fullName) { this.fullName = fullName; }
    public void setRole(Role role) { this.role = role; }
    public void setEnabled(boolean enabled) { this.enabled = enabled; }
}
