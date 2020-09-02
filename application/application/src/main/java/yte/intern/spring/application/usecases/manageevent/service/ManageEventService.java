package yte.intern.spring.application.usecases.manageevent.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import yte.intern.spring.application.usecases.common.MessageResponse;
import yte.intern.spring.application.usecases.common.enums.MessageType;
import yte.intern.spring.application.usecases.manageevent.entity.Event;
import yte.intern.spring.application.usecases.manageevent.repository.EventRepository;

import java.util.List;
@Service
@RequiredArgsConstructor
public class ManageEventService {
    @Autowired
    private final EventRepository eventRepository;

    public MessageResponse addEvent(Event event){
        eventRepository.save(event);
        return new MessageResponse("Successfully added event!", MessageType.SUCCESS);
    }

    public List<Event> listAllEvents() { return eventRepository.findAll();   }

    public Event getEventByEventName(String eventName){
        return eventRepository.findByEventName(eventName);
    }

    public MessageResponse updateEvent(String eventName, Event event){
        Event eventFromDB = eventRepository.findByEventName(eventName);
        if(eventFromDB != null){
            eventFromDB.setEventName(event.getEventName());
            eventFromDB.setLatitude(event.getLatitude());
            eventFromDB.setLongitude(event.getLongitude());
            eventFromDB.setEventStartDate(event.getEventStartDate());
            eventFromDB.setEventEndDate(event.getEventEndDate());
            eventFromDB.setQuota(event.getQuota());

            eventRepository.save(eventFromDB);
            return new MessageResponse(String.format("Successfully updated event with the name:%s",eventName),MessageType.SUCCESS);
        }
        else{
            return new MessageResponse(String.format("Can't find event with the name:%s",eventName),MessageType.ERROR);
        }
    }
    public MessageResponse deleteEvent(String eventName){
        eventRepository.deleteByEventName(eventName);
        return new MessageResponse(String.format("Deleted the event with the name:%s",eventName),MessageType.SUCCESS);
    }
}

