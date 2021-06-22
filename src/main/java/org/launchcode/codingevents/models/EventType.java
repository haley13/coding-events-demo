package org.launchcode.codingevents.models;

/**
 * Created by Chris Bay
 */
public enum EventType {//enum type converts a string to a number; similar to index position in an ArrayList(example)
//is just a dropdown list in java
    CONFERENCE("Conference"),
    MEETUP("Meetup"),
    WORKSHOP("Workshop"),
    SOCIAL("Social");

    private final String displayName;

    EventType(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
