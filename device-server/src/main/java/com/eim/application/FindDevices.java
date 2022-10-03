package com.eim.application;

import com.eim.domain.Device;
import com.eim.domain.DeviceFinder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class FindDevices {

    private final DeviceFinder deviceFinder;

    public List<Device> execute() {
        return deviceFinder.findAll();
    }

}
