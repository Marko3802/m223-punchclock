package ch.zli.m223.punchclock.service;

import ch.zli.m223.punchclock.domain.Entry;
import ch.zli.m223.punchclock.domain.Event;
import ch.zli.m223.punchclock.repository.EventRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventService {
    private EventRepository eventRepository;

    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    public Event createEvent(Event event) {
        return eventRepository.saveAndFlush(event);
    }
    public List<Event> findAll() {
        return eventRepository.findAll();
    }

    public void deleteEvent(Long id){
        eventRepository.deleteById(id);
    }

    public Event updateEvent(Event event, Long id){
        eventRepository.findById(id);
        return event;
    }

    public void findById(Long id){
        eventRepository.findById(id);
    }
}
