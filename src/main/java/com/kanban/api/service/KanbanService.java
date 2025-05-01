package com.kanban.api.service;

import com.kanban.api.dto.TaskDTO;
import com.kanban.api.enums.TaskStatus;
import com.kanban.api.exception.TaskNotFoundException;
import com.kanban.api.model.Task;
import com.kanban.api.repository.KanbanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KanbanService {

    private final KanbanRepository repository;

    @Autowired
    public KanbanService(KanbanRepository repository) {
        this.repository = repository;
    }

    //GET ALL TASKS
    public List<Task> getAllTasks(){
        return repository.findAll();
    }

    // GET ONE TASK
    public Task getTask(Long id){
        return repository.findById(id)
                .orElseThrow(() -> new TaskNotFoundException(id));
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

    //  MARK TASK AS DONE
    public Task taskDone(Long id){
        return repository.findById(id)
                .map(task1 -> {
                    task1.setStatus(TaskStatus.DONE);
                    return repository.save(task1);
                })
                .orElseThrow(() -> new TaskNotFoundException(id));
    }

    //  MARK TASK AS CANCELED
    public Task taskCanceled(Long id){
        return repository.findById(id)
                .map(task1 -> {
                    task1.setStatus(TaskStatus.CANCELED);
                    return repository.save(task1);
                })
                .orElseThrow(() -> new TaskNotFoundException(id));
    }

    //  MARK TASK AS TESTING
    public Task taskInTest(Long id){
        return repository.findById(id)
                .map(task1 -> {
                    task1.setStatus(TaskStatus.TESTING);
                    return repository.save(task1);
                })
                .orElseThrow(() -> new TaskNotFoundException(id));
    }

    //  MARK TASK AS TO-DO
    public Task taskToDo(Long id){
        return repository.findById(id)
                .map(task1 -> {
                    task1.setStatus(TaskStatus.TODO);
                    return repository.save(task1);
                })
                .orElseThrow(() -> new TaskNotFoundException(id));
    }

    //  MARK TASK AS IN PROGRESS
    public Task taskInProgress(Long id){
        return repository.findById(id)
                .map(task1 -> {
                    task1.setStatus(TaskStatus.TODO);
                    return repository.save(task1);
                })
                .orElseThrow(() -> new TaskNotFoundException(id));
    }


    // EDIT DESCRIPTION
    public Task editTask(Long id, TaskDTO task){
        Task existingTask = repository.findById(id)
                .orElseThrow(() -> new TaskNotFoundException(id));

        existingTask.setTitle(task.getTitle());
        existingTask.setDescription(task.getDescription());
        return repository.save(existingTask);
    }



}
