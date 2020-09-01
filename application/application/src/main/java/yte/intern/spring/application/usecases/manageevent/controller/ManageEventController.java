package yte.intern.spring.application.usecases.manageevent.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import yte.intern.spring.application.usecases.common.MessageResponse;
import yte.intern.spring.application.usecases.manageevent.dto.EventDTO;
import yte.intern.spring.application.usecases.manageevent.entity.Event;
import yte.intern.spring.application.usecases.manageevent.mapper.EventMapper;
import yte.intern.spring.application.usecases.manageevent.service.ManageEventService;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/events")
public class ManageEventController {

    private final EventMapper eventMapper;
    private final ManageEventService manageEventService;

    @PostMapping
    public MessageResponse addEvent(@RequestBody EventDTO eventDTO){
        Event event = eventMapper.mapToEntity(eventDTO);
        return manageEventService.addEvent(event);
    }

    @GetMapping
    public List<EventDTO> listAllEvents(){
        List<Event> events = manageEventService.listAllEvents();

        return eventMapper.mapToDto(events);

    }

    @GetMapping("/{eventName}")
    public EventDTO getEventByEventName(@PathVariable String eventName){
        Event event = manageEventService.getEventByEventName(eventName);
        return eventMapper.mapToDto(event);
    }

    @PutMapping("/{eventName}")
    public MessageResponse updateEvent(@PathVariable String eventName, @RequestBody EventDTO eventDTO){
        Event event = eventMapper.mapToEntity(eventDTO);
        return manageEventService.updateEvent(eventName, event);
    }

    @DeleteMapping("/{eventName}")
    public MessageResponse deleteEventByEventName(@PathVariable String eventName){
        return manageEventService.deleteEvent(eventName);
    }
}
