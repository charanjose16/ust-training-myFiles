package com.ust.taskmanagement.Task.Management.controller;

import com.ust.taskmanagement.Task.Management.model.Status;
import com.ust.taskmanagement.Task.Management.model.Task;
import com.ust.taskmanagement.Task.Management.repository.TaskRepository;
import com.ust.taskmanagement.Task.Management.services.TaskServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

//@CrossOrigin(origins = {"http://127.0.0.1:5500"})
@RestController
@RequestMapping("/api/v1/task")
public class TaskRestController {

    @Autowired
    private TaskServiceImpl service;

    @PostMapping
//    @ResponseStatus(code = HttpStatus.CREATED)
    public void addTask(@RequestBody Task task){
        service.addTask(task);
    }

    @GetMapping
//    @ResponseStatus(code = HttpStatus.OK)
    public ResponseEntity<List<Task>> getAllTask(){
        List<Task>tasks=service.viewAllTasks();
        return ResponseEntity.status(HttpStatus.OK).body(tasks);
    }

    @GetMapping("/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public Task getTaskByTaskId(@PathVariable("id") int id){
        return service.getTaskById(id);
    }

    @PutMapping("/delete/{id}")
    public void deleteTask(@PathVariable("id") int id){
        service.deleteTask(id);
    }

    @PutMapping("/{id}")
    public Task updateTask(@PathVariable("id") int id,@RequestBody Task task){
        return service.updateTask(id,task);
    }

    @GetMapping("/status/{status}")
    public List<Task> getTasksByStatus(@PathVariable("status") Status status){
        return service.getTasksByStatus(status);
    }

    @GetMapping("/OverDueTasks")
    public List<Task> getAllOverDueTasks(){
        return service.getOverDueTasks();
    }

    @GetMapping("/sort")
    public List<Task> getSortedTasks(){
        return service.sortedTasks();
    }

    @GetMapping("/deleted")
    public List<Task> deletedTasks(){
        return service.getDeletedTasks();
    }
}
