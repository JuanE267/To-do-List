package com.todo.api.dto;

public class TaskDTO {

    private long id;
    private String description;
    private String status;
    private String title;

    public TaskDTO() {
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() { return title; }

    public void setTitle(String title) { this.title = title; }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
