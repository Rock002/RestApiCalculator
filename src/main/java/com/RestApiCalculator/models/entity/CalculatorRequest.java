package com.RestApiCalculator.models.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "calculator_request")
public class CalculatorRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    @Column(name = "first")
    private double first;
    @Column(name = "second")
    private double second;
    @Column(name = "operation")
    private String operation;
    @Column(name = "result")
    private double result;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn
    private User user;

    public Long getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public double getResult() {
        return result;
    }

    public double getFirst() {
        return first;
    }

    public double getSecond() {
        return second;
    }

    public String getOperation() {
        return operation;
    }

    public void setResult(double result) {
        this.result = result;
    }

    public void setFirst(double first) {
        this.first = first;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public void setSecond(double second) {
        this.second = second;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
