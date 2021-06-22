package org.launchcode.codingevents.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Size;
import java.util.Objects;

@Entity
public class EventCategory extends AbstractEntity {

    private String name;

    public EventCategory(@Size(min=3, message="Name must be at least 3 characters long") String name){
        this.name=name;
    }

    public EventCategory() {};

    public String getName() {
        return name;
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
