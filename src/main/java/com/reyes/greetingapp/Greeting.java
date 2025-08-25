package com.reyes.greetingapp;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class Greeting {

    @NotNull(message = "Student ID cannot be null")
    @Size(min = 1, message = "Student ID cannot be empty")
    private String studentId;

    @NotNull(message = "Month cannot be null")
    @Min(value = 1, message = "Month must be between 1 and 12")
    @Max(value = 12, message = "Month must be between 1 and 12")
    private Integer month; // Use Integer instead of int to allow @NotNull to work for validation

    @NotNull(message = "Day cannot be null")
    @Min(value = 1, message = "Day must be between 1 and 31")
    @Max(value = 31, message = "Day must be between 1 and 31")
    private Integer day; // Use Integer instead of int

    @NotNull(message = "Year cannot be null")
    @Min(value = 1900, message = "Year must be 1900 or later")
    @Max(value = 2100, message = "Year must be 2100 or earlier") // Example range, adjust as needed
    private Integer year; // Use Integer instead of int

    @NotNull(message = "Message cannot be null")
    @Size(min = 1, message = "Message cannot be empty")
    private String message;

    // ... (rest of your constructor, getters, and setters remain the same) ...

    public Greeting() {
    }

    public Greeting(String studentId, Integer month, Integer day, Integer year, String message) {
        this.studentId = studentId;
        this.month = month;
        this.day = day;
        this.year = year;
        this.message = message;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }

    public Integer getDay() {
        return day;
    }

    public void setDay(Integer day) {
        this.day = day;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}