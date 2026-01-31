package com.lewis.devicemonitor.service;

import com.lewis.devicemonitor.api.dto.DeviceCheckInRequest;
import com.lewis.devicemonitor.domain.DeviceStatus;
import com.lewis.devicemonitor.repo.DeviceStatusRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

@Service
public class DeviceService {

    private static final Logger log =
            LoggerFactory.getLogger(DeviceService.class);

    private final DeviceStatusRepository repo;

    public DeviceService(DeviceStatusRepository repo) {
        this.repo = repo;
    }

    public DeviceStatus checkIn(DeviceCheckInRequest req) {
        Instant now = Instant.now();

        DeviceStatus device = repo.findByDeviceId(req.getDeviceId())
                .map(existing -> {
                    existing.update(req.getBatteryPercent(),
                                    req.getNetworkType(),
                                    now);
                    return existing;
                })
                .orElse(new DeviceStatus(
                        req.getDeviceId(),
                        req.getBatteryPercent(),
                        req.getNetworkType(),
                        now));

        log.info("Device check-in: {}", req.getDeviceId());
        return repo.save(device);
    }

    public List<DeviceStatus> listDevices() {
        return repo.findAll();
    }
}
