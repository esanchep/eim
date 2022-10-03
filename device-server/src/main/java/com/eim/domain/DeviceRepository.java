package com.eim.domain;

import java.util.List;
import java.util.Optional;

public interface DeviceRepository {

    void save(Device device);

    Optional<Device> find(String eid);

    List<Device> findAll();

}
