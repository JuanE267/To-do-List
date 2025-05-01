package com.kanban.api.mappers;

import com.kanban.api.dto.TaskDTO;
import com.kanban.api.model.Task;

public class TaskMapper {

    public static TaskDTO mapToDto(Task task){
        TaskDTO dto = new TaskDTO();

        dto.setTitle(task.getTitle());
        dto.setDescription(task.getDescription());

        return dto;
    }

    public static Task mapToEntity(TaskDTO task){
        Task entity = new Task();

        entity.setTitle(task.getTitle());
        entity.setDescription(task.getDescription());

        return entity;
    }
}
