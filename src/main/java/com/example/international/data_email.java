package com.example.international;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class data_email {

    private final StringProperty Fname;
    private final StringProperty Lname;
    private final StringProperty email;


    public data_email() {
        Fname = new SimpleStringProperty(this,"Fname");
       Lname = new SimpleStringProperty(this, "Lname");
       email = new SimpleStringProperty(this, "email");
    }

    @Override
    public boolean equals(Object obj) {
        return false;
    }

    @Override
    public int hashCode() {
        return 0;
    }


    public StringProperty FnameProperty(){return Fname;}
    public String getFname(){return Fname.get();}
    public void setFname(String newFname) {Fname.set(newFname);}

    public StringProperty LnameProperty(){return Lname;}
    public String getLname(){return Lname.get();}
    public void setLname(String newLname) {Lname.set(newLname);}

    public StringProperty emailProperty(){return email;}
    public String getemail(){return email.get();}
    public void setemail(String newemail) {email.set(newemail);}

    @Override
    public String toString(){
        return String.format("%s[id=%s, name=%s]",
        getFname(),getLname(),getemail());
    }
}
