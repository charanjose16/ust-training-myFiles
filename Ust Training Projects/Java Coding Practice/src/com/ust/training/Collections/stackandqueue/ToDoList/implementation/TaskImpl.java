package com.ust.training.Collections.stackandqueue.ToDoList.implementation;

import com.ust.training.Collections.stackandqueue.ToDoList.model.Status;
import com.ust.training.Collections.stackandqueue.ToDoList.model.Task;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

public class TaskImpl {
    Queue<Task> taskList=new PriorityQueue<>((t1,t2)-> t1.getPriority()- t2.getPriority());
    Stack<Task> completedTask=new Stack<>();

    public void addTask(){
        taskList.offer(new Task(Status.PENDING,3,"Read books"));
        taskList.offer(new Task(Status.PENDING,6,"Go Gym"));
        taskList.offer(new Task(Status.PENDING,1,"Play BGMI"));
        taskList.offer(new Task(Status.PENDING,4,"Learn Python"));
        taskList.offer(new Task(Status.PENDING,9,"Eat Dinner"));

    }


    public void changeStatus(){
        while (!taskList.isEmpty()){
        Task a=taskList.poll();
            System.out.println(a);
        a.setStatus(Status.COMPLETED);
        System.out.println(a.getTitle() +" : Completed");
            System.out.println();
        completedTask.push(a);
        }
    }

    public void readCompletedTask(){
        while (!completedTask.isEmpty()){
            System.out.println(completedTask.pop());
        }
    }

    public static void main(String[] args) {
        TaskImpl t1=new TaskImpl();
        t1.addTask();
        t1.changeStatus();
        t1.readCompletedTask();
    }

}
