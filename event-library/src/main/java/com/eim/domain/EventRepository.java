package com.eim.domain;

import java.util.List;

public interface EventRepository {

    Event save(final Event event);

    List<Event> findAll();

}
