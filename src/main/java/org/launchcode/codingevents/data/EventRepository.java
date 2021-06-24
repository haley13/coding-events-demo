package org.launchcode.codingevents.data;

import org.launchcode.codingevents.models.Event;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository//this flags to Spring Boot that this should be considered a repository class, or a class
//thats going to store objects in the database, so it will autocreate one of these, magic that happens
public interface EventRepository extends CrudRepository<Event,Integer> {
}
