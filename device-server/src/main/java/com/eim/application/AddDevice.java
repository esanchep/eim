package com.eim.application;

import com.eim.domain.Device;
import com.eim.domain.DeviceAdder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AddDevice {

    private final DeviceAdder deviceAdder;

    public void add(final Device device) {
        deviceAdder.add(device);
    }

}
