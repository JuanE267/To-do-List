package com.todo.api.controller;

import com.todo.api.dto.TaskDTO;
import com.todo.api.model.Task;
import com.todo.api.service.TaskService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.todo.api.mappers.TaskMapper.mapToDto;
import static com.todo.api.mappers.TaskMapper.mapToEntity;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService service;

    public TaskController(TaskService service){
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
    public Task createTask(@RequestBody TaskDTO task){
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
    public TaskDTO editTaskDescription(@PathVariable Long id, @RequestBody TaskDTO task){
        return mapToDto(service.editTask(id,  task));
    }

}
