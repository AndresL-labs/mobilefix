package com.example.mobilefix.repository;

import com.example.mobilefix.model.Device;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeviceRepository extends JpaRepository<Device, Long> {
}
