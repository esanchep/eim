package com.eim.infrastructure;

import com.eim.domain.Device;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface JpaDeviceRepository extends JpaRepository<Device, Integer> {

    Optional<Device> findByEid(String eid);

}
