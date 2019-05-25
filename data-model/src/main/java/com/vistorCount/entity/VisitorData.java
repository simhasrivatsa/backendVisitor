package com.vistorCount.entity;

import java.sql.Time;
import java.sql.Timestamp;

public class VisitorData {

    private String ipAddress;
    private Timestamp visitTime;

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public Timestamp getVisitTime() {
        return this.visitTime;
    }

    public void setVisitTime(Timestamp visitTime) {
        this.visitTime = visitTime;
    }
}
