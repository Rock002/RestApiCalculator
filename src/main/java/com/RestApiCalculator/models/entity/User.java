package com.RestApiCalculator.models.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import java.util.List;

@Entity
@Table(name = "user1")
@AllArgsConstructor
@NoArgsConstructor
@EnableWebSecurity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    @Column(name = "username")
    private String username;
    @Column(name = "password")
    private String password;
    @Column(name = "roles")
    private String roles;
    @Column(name = "history")
    @OneToMany
    private List<CalculatorRequest> history;

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getRoles() {
        return roles;
    }

    public List<CalculatorRequest> getHistory() {
        return history;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setHistory(List<CalculatorRequest> history) {
        this.history = history;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }
}
