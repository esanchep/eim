package com.eim;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import static com.eim.Try.execute;

@Slf4j
@RequiredArgsConstructor
@Service
public class ActiveMQConnector {

    private static final String DOWNLOAD_PROFILE_TOPIC = "downloadProfile";
    private static final String DOWNLOAD_PROFILE_RESULT_TOPIC = "downloadProfileResult";

    private final JmsTemplate jmsTemplate;

    public void sendDownloadProfile(final String message) {
        log.info("Sending downloadProfile \"{}\" message to broker", message);
        jmsTemplate.convertAndSend(DOWNLOAD_PROFILE_TOPIC, message);
        log.info("Message \"{}\" published to topic \"{}\" successfully.", message, DOWNLOAD_PROFILE_TOPIC);
    }

    @JmsListener(destination = DOWNLOAD_PROFILE_RESULT_TOPIC)
    public void processDownloadProfileResult(final String message) {
        final Executor sayHello = () -> System.out.println("Hello Marc");

        final String salutation = execute(sayHello)
                .run();

        log.info("Download Profile result message received: {}", message);
        log.info("Sending result to POD");
    }

}
