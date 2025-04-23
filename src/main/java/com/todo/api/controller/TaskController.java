package com.todo.api.controller;




import com.todo.api.model.Task;
import com.todo.api.service.TaskService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService service;

    public TaskController(TaskService service){
        this.service = service;
    }

    @GetMapping
    public List<Task> getAllTasks(){
        return service.getAll();
    }

    @PostMapping
    public Task createTask(@RequestBody Task task){
        return service.addTask(task);
    }

    @DeleteMapping("/{id}")
    public boolean deleteTask(@PathVariable Long id){
        return service.deleteTask(id);
    }

    @PutMapping("/{id}/complete")
    public Task completeTask(@PathVariable Long id){
        return service.completeTask(id);
    }
}
