package com.todo.api.service;




import com.todo.api.model.Task;
import com.todo.api.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    private final TaskRepository repository;

    @Autowired
    public TaskService(TaskRepository repository) {
        this.repository = repository;
    }

    public List<Task> getAll(){
        return repository.findAll();
    }

    public Task  addTask(Task task){
        repository.save(task);
        return task;
    }

    public boolean  deleteTask(Long id){
        if(repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }

    public Task completeTask(Long id){
        return repository.findById(id)
                .map(task1 -> {
                    task1.setCompleted(true);
                    return repository.save(task1);
                })
                .orElseThrow(() -> new RuntimeException("Task not found with id: " + id));
    }

}
