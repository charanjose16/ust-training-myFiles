package com.ust.taskmanagement.Task.Management.services;

import com.ust.taskmanagement.Task.Management.model.Status;
import com.ust.taskmanagement.Task.Management.model.Task;

import java.time.LocalDate;
import java.util.List;

public interface TaskService {
    public void addTask(Task task);
    public List<Task> viewAllTasks();
    public Task getTaskById(int id);
    public Task deleteTask(int id);
    public Task updateTask(int id,Task task);
    public List<Task> getTasksByStatus(Status status);
    public List<Task> getOverDueTasks();
    public List<Task> sortedTasks();
    public List<Task> getDeletedTasks();
}
