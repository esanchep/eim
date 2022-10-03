package com.eim.domain;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class DeviceAdder {

    private final DeviceRepository deviceRepository;

    public void add(final Device device) {
        deviceRepository.save(device);
    }

}
