package org.launchcode.codingevents.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

    private static List<String> events = new ArrayList<>();

   @GetMapping
   public String displayAllEvents(Model model) {
       HashMap<String, String> events = new HashMap();
           events.put("Strange Loop","Conference to developers.");
           events.put("Code With Pride","LaunchCode LGBTQ+ affinity group");
           events.put("Apple WWDC","Apple conference");
           model.addAttribute("events", events);

           return "events/index";

       }


//        model.addAttribute("title", "All Events");
//        model.addAttribute("events", events);
//        return "events/index";
    //}

    @GetMapping("create")
    public String displayCreateEventForm(Model model) {
        model.addAttribute("title", "Create Event");
        return "events/create";
    }

    @PostMapping("create")
    public String processCreateEventForm(@RequestParam String eventName) {
        events.add(eventName);
        return "redirect:";
    }

}
