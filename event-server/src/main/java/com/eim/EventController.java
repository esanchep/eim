package com.eim;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping(path = "event")
public class EventController {

    private final ActiveMQConnector activeMQConnector;

    @GetMapping(consumes = MediaType.ALL_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<List<String>> getEvents() {
        final List<String> events = activeMQConnector.getEvents();
        log.info("Returning events:");
        log.info(events.toString());
        return ResponseEntity.ok(events);
    }

}
