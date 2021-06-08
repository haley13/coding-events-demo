package org.launchcode.codingevents.models;

import javax.validation.constraints.*;
import java.util.Objects;

/**
 * Created by Chris Bay
 */
public class Event {

    private int id;
    private static int nextId = 1;

    @NotBlank(message = "Name is required.")
    @Size(min=3, max=50, message = "Name must be between 3 and 50 characters.")
    private String name;

    @Size(max=500, message = "Description too long!")
    private String description;

    @NotBlank(message = "Email is required.")
    @Email(message = "Invalid email. Try again.")
    private String contactEmail;

    @NotBlank(message="Location cannot be left blank.")
    private String location;

    private int numberOfAttendees;

    @AssertTrue(message = "Registration must be required at this time.")
    private boolean registrationRequired;

    private EventType type;

    public Event(String name, String description, String location,boolean registrationRequired, int numberOfAttendees, String contactEmail, EventType type) {
        this.name = name;
        this.description = description;
        this.location=location;
        this.numberOfAttendees= getNumberOfAttendees();
        this.registrationRequired=registrationRequired;

        this.contactEmail=contactEmail;
        this.type= type;
        this.id = nextId;
        nextId++;
    }
    public Event(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
    @Positive(message="Number of Attendees must be one or more.")
    public int getNumberOfAttendees() {
        return numberOfAttendees;
    }

    public void setNumberOfAttendees(int numberOfAttendees) {
        this.numberOfAttendees = numberOfAttendees;
    }

    public boolean isRegistrationRequired() {
        return registrationRequired;
    }

    public void setRegistrationRequired(boolean registrationRequired) {
        this.registrationRequired = registrationRequired;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

    public EventType getType() {
        return type;
    }

    public void setType(EventType type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return name;

    }
}