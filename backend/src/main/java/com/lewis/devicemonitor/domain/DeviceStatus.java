package com.lewis.devicemonitor.domain;

import jakarta.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "device_status",
       indexes = @Index(name = "idx_device_id", columnList = "deviceId", unique = true))
public class DeviceStatus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 64)
    private String deviceId;

    @Column(nullable = false)
    private Integer batteryPercent;

    @Column(nullable = false, length = 32)
    private String networkType;

    @Column(nullable = false)
    private Instant lastSeen;

    protected DeviceStatus() {}

    public DeviceStatus(String deviceId, Integer batteryPercent,
                        String networkType, Instant lastSeen) {
        this.deviceId = deviceId;
        this.batteryPercent = batteryPercent;
        this.networkType = networkType;
        this.lastSeen = lastSeen;
    }

    public Long getId() { return id; }
    public String getDeviceId() { return deviceId; }
    public Integer getBatteryPercent() { return batteryPercent; }
    public String getNetworkType() { return networkType; }
    public Instant getLastSeen() { return lastSeen; }

    public void update(Integer batteryPercent, String networkType, Instant lastSeen) {
        this.batteryPercent = batteryPercent;
        this.networkType = networkType;
        this.lastSeen = lastSeen;
    }
}
