package com.eim.domain;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class DeviceFinder {

    private final DeviceRepository deviceRepository;

    public Device find(final String eid) {
        return deviceRepository.find(eid)
                .orElseThrow(() -> new RuntimeException("Device not exists"));
    }

    public List<Device> findAll() {
        return deviceRepository.findAll();
    }

}
