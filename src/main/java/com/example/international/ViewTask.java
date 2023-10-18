package com.example.international;

public class ViewTask {


    int taskNo;

    String Task;

    String  Date;

    String Description;

    int TaskID;

    String TaskStatus;

    public ViewTask(int taskNo, String task, String date, String description, int taskID, String taskStatus) {
        this.taskNo = taskNo;
        this.Task = task;
        this.Date = date;
        this.Description = description;
        this.TaskID = taskID;
        this.TaskStatus = taskStatus;


    }

    public int getTaskNo() {
        return taskNo;
    }

    public void setTaskNo(int taskNo) {
        this.taskNo = taskNo;
    }

    public String getTask() {
        return Task;
    }

    public void setTask(String task) {
        Task = task;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public int getTaskID() {
        return TaskID;
    }

    public void setTaskID(int taskID) {
        TaskID = taskID;
    }

    public String getTaskStatus() {
        return TaskStatus;
    }

    public void setTaskStatus(String taskStatus) {
        TaskStatus = taskStatus;
    }
}
