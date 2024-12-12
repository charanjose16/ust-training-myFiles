package com.ust.taskmanagement.Task.Management.services;

import com.ust.taskmanagement.Task.Management.Exceptions.InvalidInputDataException;
import com.ust.taskmanagement.Task.Management.Exceptions.TaskNotFoundException;
import com.ust.taskmanagement.Task.Management.model.ActiveStatus;
import com.ust.taskmanagement.Task.Management.model.Status;
import com.ust.taskmanagement.Task.Management.model.Task;
import com.ust.taskmanagement.Task.Management.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;

@Service
public class TaskServiceImpl implements TaskService{

    @Autowired
    private TaskRepository repository;

    public void addTask(Task task){
        if(task.getName()==null || task.getName().trim().isEmpty()
                || task.getDescription()==null || task.getDescription().trim().isEmpty()
                || task.getStatus()==null
                || task.getDueDate()==null ){
            throw new InvalidInputDataException("Invalid input data");
        }
         repository.save(task);
    }

    public List<Task> viewAllTasks(){
        return repository.findAll().stream().filter(t->t.getActiveStatus()==ActiveStatus.ACTIVE).toList();
    }

    public Task getTaskById(int id){
        if(!repository.existsById(id)){
            throw new TaskNotFoundException("Task not found");
        }
        return repository.findById(id).orElse(null);
    }

    public Task deleteTask(int id){
        if(!repository.existsById(id)){
            throw new TaskNotFoundException("Task not found");
        }
        Task deleteTask = getTaskById(id);
        deleteTask.setActiveStatus(ActiveStatus.INACTIVE);
        return repository.save(deleteTask);
    }

    public Task updateTask(int id, Task task) {
        if(!repository.existsById(id)){
            throw new TaskNotFoundException("Task not found");
        }
        Task currentTask = getTaskById(id);
        if (task.getName() != null && !task.getName().isEmpty()) {
            currentTask.setName(task.getName());
        }
        else {
            throw new InvalidInputDataException("Invalid input data");
        }
        if (task.getDescription() != null && !task.getDescription().isEmpty()) {
            currentTask.setDescription(task.getDescription());
        }
        else {
            throw new InvalidInputDataException("Invalid input data");
        }
        if (task.getDueDate() != null ) {
            currentTask.setDueDate(task.getDueDate());
        }
        else {
            throw new InvalidInputDataException("Invalid input data");
        }
        if ((task.getStatus() != null) ) {
            currentTask.setStatus(task.getStatus());
        }
        else {
            throw new InvalidInputDataException("Invalid input data");
        }
        if(task.getActiveStatus()!=null){
            currentTask.setActiveStatus(task.getActiveStatus());
        }
        return repository.save(currentTask);
    }

    public List<Task> getTasksByStatus(Status status) {
        return repository.getTasksByStatus(status).stream().filter(t->t.getActiveStatus()==ActiveStatus.ACTIVE).toList();
    }

    public List<Task> getOverDueTasks() {
        return repository.getAllOverDueTasks(LocalDate.now()).stream().filter(t->t.getActiveStatus()==ActiveStatus.ACTIVE).toList();
    }

    public List<Task> sortedTasks(){
//        return repository.findAll().stream().filter(t->t.getActiveStatus()==ActiveStatus.ACTIVE).sorted(Comparator.comparing(Task::getDueDate)).toList();
        return repository.getTasksOrderByDueDate();
    }

    public List<Task> getDeletedTasks(){
//        return repository.findAll().stream().filter(t->t.getActiveStatus()==ActiveStatus.INACTIVE).toList();
        return repository.deletedTasks();
    }


}
