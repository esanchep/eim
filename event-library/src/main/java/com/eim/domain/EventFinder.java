package com.eim.domain;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class EventFinder {

    private final EventRepository eventRepository;

    public List<Event> execute() {
        return eventRepository.findAll();
    }

}
