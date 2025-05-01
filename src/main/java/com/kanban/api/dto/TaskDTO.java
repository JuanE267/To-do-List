package com.kanban.api.dto;

public class TaskDTO {

    private String title;
    private String description;

    public TaskDTO() {
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() { return title; }

    public void setTitle(String title) { this.title = title; }

}
