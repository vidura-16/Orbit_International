package com.example.international;

public class AddTask {

         String EmpID;

         int taskNo;

         String Task;

         String  Date;

         String Position;

         String Description;

         int TaskID;

         String TaskStatus;

    public AddTask(int taskID, int taskNo, String task, String empID, String date, String position, String description, String taskStatus ) {
            this.TaskID=taskID;
            this.EmpID = empID;
            this.taskNo= taskNo;
            this.Task = task;
            this.Date = date;
            this.Position = position;
            this.Description = description;
            this.TaskStatus= taskStatus;

        }

    public int getTaskID() {
        return TaskID;
    }

    public void setTaskID(int taskID) {
        TaskID = taskID;
    }

    public String getEmpID() {
        return EmpID;
    }

    public void setEmpID(String empID) {
        EmpID = empID;
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

    public String getPosition() {
        return Position;
    }

    public void setPosition(String position) {
        Position = position;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getTaskStatus() {
        return TaskStatus;
    }

    public void setTaskStatus(String taskStatus) {
        TaskStatus = taskStatus;
    }
}



