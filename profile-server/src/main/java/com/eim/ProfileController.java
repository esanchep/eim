package com.eim;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/profile",
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE)
public class ProfileController {

    private final ActiveMQConnector activeMQConnector;

    @PostMapping
    ResponseEntity<String> add(@RequestBody final Profile profile) {
        log.info("Saving profile \"{}\" to database", profile.toString());
        activeMQConnector.sendDownloadProfile("Download Profile %s".formatted(profile.toString()));
        return ResponseEntity.ok("Profile added with success");
    }

}
