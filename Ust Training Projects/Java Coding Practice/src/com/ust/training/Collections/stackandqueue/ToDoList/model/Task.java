package com.ust.training.Collections.stackandqueue.ToDoList.model;

public class Task <Task> {
    private String title;
    private int priority;
    private Status status;

    public Task(Status status, int priority, String title) {
        this.status = status;
        this.priority = priority;
        this.title = title;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Task{" +
                "title='" + title + '\'' +
                ", priority=" + priority +
                ", status=" + status +
                '}';
    }

//    public int compareTo(Task o) {
//        return this.priority-o.priority;
//    }


}
