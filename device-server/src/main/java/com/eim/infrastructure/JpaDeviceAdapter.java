package com.eim.infrastructure;

import com.eim.domain.Device;
import com.eim.domain.DeviceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class JpaDeviceAdapter implements DeviceRepository {

    private final JpaDeviceRepository jpaDeviceRepository;

    public void save(final Device device) {
        jpaDeviceRepository.save(device);
    }

    @Override
    public Optional<Device> find(final String eid) {
        return jpaDeviceRepository.findByEid(eid);
    }

    public List<Device> findAll() {
        return jpaDeviceRepository.findAll();
    }
}
