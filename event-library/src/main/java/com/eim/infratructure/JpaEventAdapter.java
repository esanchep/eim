package com.eim.infratructure;

import com.eim.domain.EventRepository;
import com.eim.domain.Event;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class JpaEventAdapter implements EventRepository {

    private final JpaEventRepository jpaEventRepository;

    @Override
    public Event save(Event event) {
        return jpaEventRepository.save(event);
    }

    @Override
    public List<Event> findAll() {
        return jpaEventRepository.findAll();
    }

}
