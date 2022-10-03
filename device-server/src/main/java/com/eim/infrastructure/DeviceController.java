package com.eim.infrastructure;

import com.eim.application.AddDevice;
import com.eim.application.FindDevice;
import com.eim.application.FindDeviceEvents;
import com.eim.application.FindDevices;
import com.eim.domain.Device;
import com.eim.domain.Event;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/device",
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE)
public class DeviceController {

    private final AddDevice addDevice;
    private final FindDevice findDevice;
    private final FindDevices findDevices;
    private final FindDeviceEvents findDeviceEvents;

    @PostMapping
    ResponseEntity<String> add(@RequestBody final Device device) {
        addDevice.add(device);
        return ResponseEntity.ok("Device added with success");
    }

    @GetMapping(consumes = MediaType.ALL_VALUE)
    ResponseEntity<List<Device>> findAll() {
        final List<Device> devices = findDevices.execute();
        return ResponseEntity.ok(devices);
    }

    @GetMapping(path = "/{eid}", consumes = MediaType.ALL_VALUE)
    ResponseEntity<Device> find(@RequestParam final String eid) {
        final Device device = findDevice.execute(eid);
        return ResponseEntity.ok(device);
    }

    @PostMapping(path = "/{eid}/event")
    ResponseEntity<String> add(@RequestBody final Event event) {
        return ResponseEntity.ok("Event added with success");
    }

    @GetMapping(path = "/{eid}/event", consumes = MediaType.ALL_VALUE)
    ResponseEntity<List<Event>> findEvents(@RequestParam final String eid) {
        final List<Event> events = findDeviceEvents.execute(eid);
        return ResponseEntity.ok(events);
    }

}
