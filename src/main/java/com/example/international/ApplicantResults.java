package com.example.international;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class ApplicantResults {
    private final StringProperty FirstName;
    private final StringProperty LastName;
    private final StringProperty Email;

    public ApplicantResults() {
        FirstName = new SimpleStringProperty(this,"firstName");
        LastName = new SimpleStringProperty(this,"lastName");
        Email = new SimpleStringProperty(this,"email");
    }

    public String getFirstName() {
        return FirstName.get();
    }

    public StringProperty firstNameProperty() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        this.FirstName.set(firstName);
    }

    public String getLastName() {
        return LastName.get();
    }

    public StringProperty lastNameProperty() {
        return LastName;
    }

    public void setLastName(String lastName) {
        this.LastName.set(lastName);
    }

    public String getEmail() {
        return Email.get();
    }

    public StringProperty emailProperty() {
        return Email;
    }

    public void setEmail(String email) {
        this.Email.set(email);
    }

    @Override
    public String toString(){
        return String.format("%s[id=%s, name=%s]",
                getFirstName(),getLastName(), getEmail());
    }
}
