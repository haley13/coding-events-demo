package org.launchcode.codingevents.models;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
public class EventCategory extends AbstractEntity {

    @Size(min=3, message="Name must be at least 3 characters long")
    private String name;

    @OneToMany(mappedBy = "eventCategory")
    private final List<Event> events= new ArrayList<>();//the list itself cannot change

    public EventCategory(@Size(min=3, message="Name must be at least 3 characters long") String name){
        this.name=name;
    }

    public EventCategory() {};

    public String getName() {
        return name;
    }

    public List<Event> getEvents() {
        return events;
    }

    public void setName(String name) {
        this.name = name;

    }
    @Override
    public String toString(){
        return name;
    }
//        return id==that.id;//I just want to look at the ids, the only thing I care about being different to identify objects as other one's we can check the id.

}
