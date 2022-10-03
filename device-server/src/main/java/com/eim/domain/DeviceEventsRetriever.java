package com.eim.domain;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class DeviceEventsRetriever {

    private final DeviceFinder deviceFinder;

    public List<Event> retrieveDeviceEvents(final String eid) {
        return deviceFinder.find(eid)
                .getEvents();
    }

}
