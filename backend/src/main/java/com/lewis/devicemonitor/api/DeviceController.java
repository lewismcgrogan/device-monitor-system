package com.lewis.devicemonitor.api;

import com.lewis.devicemonitor.api.dto.*;
import com.lewis.devicemonitor.domain.DeviceStatus;
import com.lewis.devicemonitor.service.DeviceService;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class DeviceController {

    private final DeviceService service;

    public DeviceController(DeviceService service) {
        this.service = service;
    }

    @PostMapping("/device/checkin")
    public DeviceResponse checkIn(@Valid @RequestBody DeviceCheckInRequest request) {
        DeviceStatus saved = service.checkIn(request);
        return new DeviceResponse(
                saved.getDeviceId(),
                saved.getBatteryPercent(),
                saved.getNetworkType(),
                saved.getLastSeen()
        );
    }

    @GetMapping("/devices")
    public List<DeviceResponse> listDevices() {
        return service.listDevices().stream()
                .map(d -> new DeviceResponse(
                        d.getDeviceId(),
                        d.getBatteryPercent(),
                        d.getNetworkType(),
                        d.getLastSeen()))
                .toList();
    }
}
