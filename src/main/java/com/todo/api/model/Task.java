package com.todo.api.model;

import jakarta.persistence.*;


@Entity
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String description;
    private boolean completed;

    public Task() {
    }

    public Task(long id, String description) {
        this.id = id;
        this.description = description;
        this.completed = false;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void     setCompleted(boolean completed) {
        this.completed = completed;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
