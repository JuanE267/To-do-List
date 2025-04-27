package com.todo.api.service;




import com.todo.api.dto.TaskDTO;
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

    //GET ALL TASKS
    public List<Task> getAllTasks(){
        return repository.findAll();
    }

    // GET ONE TASK
    public Task getTask(Long id){
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Task not found with id: " + id));
    }

    // CREATE TASK
    public Task addTask(Task task){
        return repository.save(task);
    }


    // DELETE TASK
    public boolean  deleteTask(Long id){
        if(repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }

    //  MARK TASK AS COMPLETE
    public Task completeTask(Long id){
        return repository.findById(id)
                .map(task1 -> {
                    task1.setStatus("Completed");
                    return repository.save(task1);
                })
                .orElseThrow(() -> new RuntimeException("Task not found with id: " + id));
    }

    // EDIT DESCRIPTION
    public Task editTaskDescription(Long id, Task task){
        Task existingTask = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Task not found with id: " + id));

        existingTask.setTitle(task.getTitle());
        existingTask.setDescription(task.getDescription());
        return repository.save(existingTask);
    }

}
