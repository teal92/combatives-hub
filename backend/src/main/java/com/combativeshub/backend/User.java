package com.combativeshub.backend;

import jakarta.persistence.*;


@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Login fields
    private String username;
    private String password;
    private boolean enabled = true;

    private String name;
    private String email;
    private String rank;
    private String unit;
    private String role; // e.g. "Instructor", "Manager"
    private String certLevel; // e.g. "Level 1", "Level 2", "Level 3"

    public User() {}


    // Constructor without ID
    public User(String username, String password, String name, String email, String rank, String unit, String role, String certLevel) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.email = email;
        this.rank = rank;
        this.unit = unit;
        this.role = role;
        this.certLevel = certLevel;
        this.enabled = true;
    }

    // Getters and Setters (you can generate these automatically in IntelliJ)

    public Long getId() {
        return id;
    }

    public String getUsername() { return username; }

    public void setUsername(String username) { this.username = username; }

    public String getPassword() { return password; }

    public void setPassword(String password) { this.password = password; }

    public boolean isEnabled() { return enabled; }

    public void setEnabled(boolean enabled) { this.enabled = enabled; }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getCertLevel() {
        return certLevel;
    }

    public void setCertLevel(String certLevel) {
        this.certLevel = certLevel;
    }
}
