package com.ust.taskmanagement.Task.Management.repository;

import com.ust.taskmanagement.Task.Management.model.Status;
import com.ust.taskmanagement.Task.Management.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task,Integer> {

    @Query("from Task where status=:status")
    public List<Task> getTasksByStatus(Status status);

    @Query("from Task where dueDate<:today and status= 'PENDING'")
    public List<Task> getAllOverDueTasks(LocalDate today);

    @Query("from Task where activeStatus='ACTIVE' order by dueDate")
    public List<Task> getTasksOrderByDueDate();

    @Query("from Task where activeStatus='INACTIVE' ")
    public List<Task> deletedTasks();
}
