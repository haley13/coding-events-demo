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
    @GetMapping("events/{eventId}")
    public String displayEditForm(Model model, @PathVariable int eventId) {
       Event selectedEvent=EventData.getById(eventId);
       EventData.getById(eventId);
       //key and value on the model; "selectedEvent" is the name that we pass into the view the bind the model to the template
       model.addAttribute("selectedEvent", selectedEvent);
       String title="Edit Event" + selectedEvent.getName() + "(id =" + selectedEvent.getId() + ")";
       model.addAttribute("title", title);
       //model.addAttribute(eventId);
        return "events/edit";
    }
    @PostMapping("edit")
    //@RequestMapping(value="eventsedit", method = {RequestMethod.GET, RequestMethod.POST})
    public String processEditForm(Model model, @RequestParam int eventId,
                                            @RequestParam String name,
                                            @RequestParam String description) {
        Event selectedEvent=EventData.getById(eventId);
        selectedEvent.setName(name);
        selectedEvent.setDescription(description);

       // model.addAttribute("events", EventData.getAll());
        return "redirect:";
    }



}
