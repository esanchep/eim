package com.eim.application;

import com.eim.domain.Device;
import com.eim.domain.DeviceFinder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class FindDevice {

    private final DeviceFinder deviceFinder;

    public Device execute(final String eid) {
        final Device device = deviceFinder.find(eid);
        return Device.builder()
                .eid(device.getEid())
                .build();
    }

}
