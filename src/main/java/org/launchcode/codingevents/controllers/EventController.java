package org.launchcode.codingevents.controllers;

import org.launchcode.codingevents.data.EventData;
import org.launchcode.codingevents.models.Event;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Chris Bay
 */
@Controller
@RequestMapping("events")
public class EventController {

   @GetMapping
   public String displayAllEvents(Model model) {
       model.addAttribute("title", "All Events");
       model.addAttribute("events", EventData.getAll());
           return "events/index";

       }
    @GetMapping("create")
    public String displayCreateEventForm(Model model) {
        model.addAttribute("title", "Create Event");
        return "events/create";
    }

    @PostMapping("create")
    public String processCreateEventForm(@ModelAttribute Event newEvent) {
        EventData.add(newEvent);
        return "redirect:";
    }
    @GetMapping("delete")
    public String displayDeleteEventForm(Model model){
       model.addAttribute("title", "Delete Events");
       model.addAttribute("events", EventData.getAll());
       return "events/delete";
    }
    @PostMapping("delete")
    public String processDeleteEventsForm(@RequestParam(required = false) int[] eventIds) {

        if (eventIds != null) {
            for (int id : eventIds) {
                EventData.remove(id);
            }
        }

        return "redirect:";
    }
    @GetMapping("edit/{eventId}")
    public String displayEditForm(Model model, @PathVariable int eventId) {
       //@PathVariable tells Spring Boot that this particular handler is looking for a request to /hello/name and that
        //name can be anything, and we're going to take the value of that piece of data, the value of that anything and place
        //it in the method parameter name, variable we defined in the path template needs to be the
        //exact same as the variable in the method parameter list; the variable is part of the paths
        Event selectedEvent = EventData.getById(eventId);
        model.addAttribute("selectedEvent", selectedEvent);
        String title = "Edit Event" + selectedEvent.getName() + "(id=" + selectedEvent.getId() + ")";
        model.addAttribute("title", title);
        return "events/edit";
    }

    @PostMapping("edit")
    public String processEditForm(int eventId, String name, String description) {
        Event selectedEvent = EventData.getById(eventId);
        selectedEvent.setName(name);
        selectedEvent.setDescription(description);
        return "redirect:";
    }



}
