package com.example.demo.models;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity(name = "taskLog")
public class TaskLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime timestamp;
    private boolean success;

    public TaskLog() {
    }

    public TaskLog(LocalDateTime timestamp, boolean success) {
        this.timestamp = timestamp;
        this.success = success;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}