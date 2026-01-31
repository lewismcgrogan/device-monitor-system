package com.lewis.devicemonitor.api.dto;

import java.time.Instant;

public class DeviceResponse {
    private String deviceId;
    private Integer batteryPercent;
    private String networkType;
    private Instant lastSeen;

    public DeviceResponse(String deviceId, Integer batteryPercent, String networkType, Instant lastSeen) {
        this.deviceId = deviceId;
        this.batteryPercent = batteryPercent;
        this.networkType = networkType;
        this.lastSeen = lastSeen;
    }

    public String getDeviceId() { return deviceId; }
    public Integer getBatteryPercent() { return batteryPercent; }
    public String getNetworkType() { return networkType; }
    public Instant getLastSeen() { return lastSeen; }
}
