# Device Monitor System

A full-stack **device check-in + monitoring** system:

- **Android client (Java)** collects device telemetry (battery % + network type) and sends it to a backend
- **Spring Boot backend (Java)** stores latest device status and exposes a REST API to view devices

This project is intentionally built to resemble real-world “device + server” workflows found in **telecommunications / mobile systems**, where devices periodically report status and engineers monitor them via APIs or dashboards.

---

## ✨ Features

### Android App
- One-tap **“Send Status”** check-in
- Captures:
  - Battery percentage
  - Network transport (WIFI / CELLULAR / ETHERNET / OTHER)
- Uses **Retrofit** for API calls
- Works on **Android Emulator** (special localhost routing)

### Backend (Spring Boot)
- REST API for device check-ins and listing devices
- Stores the **latest** status per `deviceId`
- Uses an embedded DB (H2) for easy local development
- Designed to be extendable to PostgreSQL / MySQL

---

## 🧱 Architecture

Android App (Retrofit)
|
| POST /api/device/checkin
| 
v
Spring Boot REST API
|
v
H2 Database (latest device status)

---

##  ✅ API Endpoints

### Check-in (from device)
`POST /api/device/checkin`

Example:
```bash
curl -X POST http://localhost:8080/api/device/checkin \
  -H "Content-Type: application/json" \
  -d '{"deviceId":"lewis-test-1","batteryPercent":87,"networkType":"WIFI"}'


---
### List devices

GET /api/devices

Example:
curl http://localhost:8080/api/devices | python3 -m json.tool


