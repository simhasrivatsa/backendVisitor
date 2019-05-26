package com.vistorCount.response;

import java.sql.Timestamp;

public class UniqueVisitorCountResponse implements ApiResponse {

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Timestamp getTimeOfResult() {
        return timeOfResult;
    }

    public void setTimeOfResult(Timestamp timeOfResult) {
        this.timeOfResult = timeOfResult;
    }

    private Integer count;
    private Timestamp timeOfResult;
    private Integer visiterNumber;

    public Integer getVisiterNumber() {
        return visiterNumber;
    }

    public void setVisiterNumber(Integer visiterNumber) {
        this.visiterNumber = visiterNumber;
    }
}
