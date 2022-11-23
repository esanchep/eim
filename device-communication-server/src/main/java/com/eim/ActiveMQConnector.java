package com.eim;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class ActiveMQConnector {

    private static final String DOWNLOAD_PROFILE_TOPIC = "downloadProfile";
    private static final String DOWNLOAD_PROFILE_RESULT_TOPIC = "downloadProfileResult";

    private final JmsTemplate jmsTemplate;

    @JmsListener(destination = DOWNLOAD_PROFILE_TOPIC)
    public void processDownloadProfile(final String message) {
        log.info("Received downloadProfile request for message \"{}\"", message);
        log.info("Send the downloadProfile to IPA");
        sendDownloadProfileResult("Profile downloaded with success");
    }

    public void sendDownloadProfileResult(final String message) {
        log.info("Sending the downloadProfileResult message topic to broker");
        jmsTemplate.convertAndSend(DOWNLOAD_PROFILE_RESULT_TOPIC, message);
        log.info("Message \"{}\" published to topic \"{}\" successfully.", message, DOWNLOAD_PROFILE_RESULT_TOPIC);
    }

}
