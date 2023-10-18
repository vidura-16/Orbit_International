package com.example.international;

public class Employee {
    String FirstName;
    String LastName;
    String Position;
    String Email;
    String Username;
    String Password;
    String Salary;
    String Contact;
    String DateOfJoin;
    String NIC;
    String Address;
    String DOB;
    String Gender;
    int ID;

    public Employee(String firstName, String lastName, String position, String email, String username, String password,
                    String salary, String contact, String dateOfJoin, String NIC, String address, String DOB, String gender, int ID) {
        FirstName = firstName;
        LastName = lastName;
        Position = position;
        Email = email;
        Username = username;
        Password = password;
        Salary = salary;
        Contact = contact;
        DateOfJoin = dateOfJoin;
        this.NIC = NIC;
        Address = address;
        this.DOB = DOB;
        Gender = gender;
        this.ID = ID;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getPosition() {
        return Position;
    }

    public void setPosition(String position) {
        Position = position;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getSalary() {
        return Salary;
    }

    public void setSalary(String salary) {
        Salary = salary;
    }

    public String getContact() {
        return Contact;
    }

    public void setContact(String contact) {
        Contact = contact;
    }

    public String getDateOfJoin() {
        return DateOfJoin;
    }

    public void setDateOfJoin(String dateOfJoin) {
        DateOfJoin = dateOfJoin;
    }

    public String getNIC() {
        return NIC;
    }

    public void setNIC(String NIC) {
        this.NIC = NIC;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getDOB() {
        return DOB;
    }

    public void setDOB(String DOB) {
        this.DOB = DOB;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String gender) {
        Gender = gender;
    }
}

