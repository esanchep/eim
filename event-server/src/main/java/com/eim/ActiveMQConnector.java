package com.eim;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Slf4j
@RequiredArgsConstructor
@Service
public class ActiveMQConnector {

    private static final String DOWNLOAD_PROFILE_TOPIC = "downloadProfile";
    private static final String DOWNLOAD_PROFILE_RESULT_TOPIC = "downloadProfileResult";

    private final JmsTemplate jmsTemplate;
    private final List<String> events = new ArrayList<>();

    @JmsListener(destination = DOWNLOAD_PROFILE_TOPIC)
    public void processDownloadProfile(final String message) {
        log.info("Adding downloadProfile event \"{}\"", message);
        events.add(message);
    }

    @JmsListener(destination = DOWNLOAD_PROFILE_RESULT_TOPIC)
    public void processDownloadProfileResult(final String message) {
        log.info("Adding downloadProfileResult event \"{}\"", message);
        events.add(message);
    }

    public List<String> getEvents() {
        return events;
    }

}
