package com.lewis.devicemonitor.api.dto;

import jakarta.validation.constraints.*;

public class DeviceCheckInRequest {

    @NotBlank
    @Size(max = 64)
    private String deviceId;

    @Min(0)
    @Max(100)
    private Integer batteryPercent;

    @NotBlank
    @Size(max = 32)
    private String networkType;

    public DeviceCheckInRequest() {}

    public String getDeviceId() { return deviceId; }
    public Integer getBatteryPercent() { return batteryPercent; }
    public String getNetworkType() { return networkType; }

    public void setDeviceId(String deviceId) { this.deviceId = deviceId; }
    public void setBatteryPercent(Integer batteryPercent) { this.batteryPercent = batteryPercent; }
    public void setNetworkType(String networkType) { this.networkType = networkType; }
}
