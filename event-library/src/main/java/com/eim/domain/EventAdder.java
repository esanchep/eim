package com.eim.domain;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class EventAdder {

    private final EventRepository eventRepository;

    public Event execute(final Event event) {
        return eventRepository.save(event);
    }

}
