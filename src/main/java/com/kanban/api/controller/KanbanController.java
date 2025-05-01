package com.kanban.api.controller;

import com.kanban.api.dto.TaskDTO;
import com.kanban.api.model.Task;
import com.kanban.api.service.KanbanService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.kanban.api.mappers.TaskMapper.mapToDto;
import static com.kanban.api.mappers.TaskMapper.mapToEntity;

@RestController
@RequestMapping("/tasks")
public class KanbanController {

    private final KanbanService service;

    public KanbanController(KanbanService service){
        this.service = service;
    }

    @GetMapping
    public List<Task> getAllTasks(){
        List<Task> listOfTasks = service.getAllTasks();
        return listOfTasks;
    }

    @GetMapping("/{id}")
    public Task getTaskById(@PathVariable Long id){
        return service.getTask(id);
    }

    @PostMapping
    public Task createTask(@RequestBody @Valid TaskDTO task){
        return service.addTask(mapToEntity(task));
    }

    @DeleteMapping("/{id}")
    public boolean deleteTask(@PathVariable Long id){
        return service.deleteTask(id);
    }

    @PatchMapping("/{id}/complete")
    public TaskDTO completeTask(@PathVariable Long id){
        return mapToDto(service.completeTask(id));
    }

    @PatchMapping("/{id}/cancel")
    public TaskDTO cancelTask(@PathVariable Long id){
        return mapToDto(service.cancelTask(id));
    }

    @PutMapping("/{id}/edit")
    public TaskDTO editTaskDescription(@PathVariable Long id, @RequestBody @Valid TaskDTO task){
        return mapToDto(service.editTask(id,  task));
    }

}
