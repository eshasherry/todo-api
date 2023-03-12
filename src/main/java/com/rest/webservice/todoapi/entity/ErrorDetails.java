package com.rest.webservice.todoapi.entity;

import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class ErrorDetails {
    private String message;
    private LocalDate date;
    public ErrorDetails(){}
    public ErrorDetails(String message, LocalDate date) {
        this.message = message;
        this.date = date;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
