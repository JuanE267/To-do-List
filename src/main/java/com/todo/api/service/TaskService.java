package com.todo.api.service;

import com.todo.api.model.Task;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TaskService {
    private final Map<Long, Task> tasks = new HashMap<>();
    private Long idCounter = 1L;

    public List<Task> getAll(){
        return new ArrayList<>(tasks.values());
    }

    public Task  addTask(Task task){
        task.setId(idCounter++);
        tasks.put(task.getId(), task);

        return task;
    }

    public boolean  deleteTask(Long id){
        return tasks.remove(id) != null;
    }

    public Task completeTask(Long id){
        Task task = tasks.get(id);
        if (task!= null){
            task.setCompleted(true);
        }
        return task;
    }

}
