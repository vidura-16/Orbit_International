package com.example.international;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class data {

    private final IntegerProperty ID;
    private final StringProperty topic;
    private final StringProperty announcement;
    private final StringProperty date;
    private final StringProperty visibility;


    public data() {
        ID = new SimpleIntegerProperty(this,"announcementID");
       topic = new SimpleStringProperty(this, "topic");
       announcement = new SimpleStringProperty(this, "announcement");
       date = new SimpleStringProperty(this, "date");
       visibility = new SimpleStringProperty(this, "visibility");
    }

    @Override
    public boolean equals(Object obj) {
        return false;
    }

    @Override
    public int hashCode() {
        return 0;
    }

    public StringProperty topicProperty(){return topic;}
    public String getTopic(){return topic.get();}
    public void setTopic(String newTopic) {topic.set(newTopic);}

    public StringProperty announcementProperty(){return announcement;}
    public String getAnnouncement(){return announcement.get();}
    public void setAnnouncement(String newAnnouncement) {announcement.set(newAnnouncement);}

    public StringProperty dateProperty(){return date;}
    public String getDate(){return date.get();}
    public void setDate(String newDate) {date.set(newDate);}

    public StringProperty visibilityProperty(){return visibility;}
    public String getVisibility(){return visibility.get();}
    public void setVisibility(String newVisibility) {visibility.set(newVisibility);}

    @Override
    public String toString(){
        return String.format("%s[id=%s, name=%s]",
        getTopic(),getAnnouncement(),getDate(),getVisibility());
    }
}
