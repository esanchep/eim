package com.eim.application;

import com.eim.domain.DeviceEventsRetriever;
import com.eim.domain.Event;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class FindDeviceEvents {

    private final DeviceEventsRetriever deviceEventsRetriever;

    public List<Event> execute(final String eid) {
        return deviceEventsRetriever.retrieveDeviceEvents(eid);
    }

}
