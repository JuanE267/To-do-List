package com.todo.api.controller;

import com.todo.api.dto.TaskDTO;
import com.todo.api.model.Task;
import com.todo.api.service.TaskService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService service;

    public TaskController(TaskService service){
        this.service = service;
    }

    @GetMapping
    public List<TaskDTO> getAllTasks(){
        List<Task> listOfTasks = service.getAllTasks();
        List<TaskDTO> listOfDtos = new ArrayList<>();

        for(Task t : listOfTasks){
            listOfDtos.add(mapToDto(t));
        }
        return listOfDtos;
    }

    @GetMapping("/{id}")
    public TaskDTO getTaskById(@PathVariable Long id){
        return mapToDto(service.getTask(id));
    }

    @PostMapping
    public TaskDTO createTask(@RequestBody Task task){  return mapToDto(service.addTask(task)); }

    @DeleteMapping("/{id}")
    public boolean deleteTask(@PathVariable Long id){
        return service.deleteTask(id);
    }

    @PatchMapping("/{id}/complete")
    public TaskDTO completeTask(@PathVariable Long id){
        return mapToDto(service.completeTask(id));
    }

    @PutMapping("/{id}/edit")
    public TaskDTO editTaskDescription(@PathVariable Long id, @RequestBody Task task){
        return mapToDto(service.editTaskDescription(id,  task));
    }

    private TaskDTO mapToDto(Task task){
        TaskDTO dto = new TaskDTO();

        dto.setId(task.getId());
        dto.setTitle(task.getTitle());
        dto.setDescription(task.getDescription());
        dto.setStatus(task.getStatus());

        return dto;
    }
}
