package com.example.international;


public class requirementData {
   int jobID;
   int noVisa;
   String job;
   String country;
   String gender;
   String age;
   String period;
   String experience;
   double salary;

    public int getJobID() {
        return jobID;
    }

    public void setJobID(int jobID) {
        this.jobID = jobID;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public requirementData(int jobID,int noVisa ,String job, String country, String gender, String age, String period, String experience, double salary) {
        this.jobID = jobID;
        this.noVisa=noVisa;
        this.job = job;
        this.country = country;
        this.gender = gender;
        this.age = age;
        this.period = period;
        this.experience = experience;
        this.salary = salary;
    }

    public int getNoVisa() {
        return noVisa;
    }

    public void setNoVisa(int noVisa) {
        this.noVisa = noVisa;
    }
}