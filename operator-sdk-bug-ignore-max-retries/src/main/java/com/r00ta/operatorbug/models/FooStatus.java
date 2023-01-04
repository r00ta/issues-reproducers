package com.r00ta.operatorbug.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class FooStatus {

    @JsonProperty("exception_count")
    private int exceptionCount;

    public FooStatus() {
        // For Jackson
    }

    public FooStatus(int exceptionCount) {
        this.exceptionCount = exceptionCount;
    }

    public int getExceptionCount() {
        return exceptionCount;
    }

    public void setExceptionCount(int exceptionCount) {
        this.exceptionCount = exceptionCount;
    }
}
