package com.example.accessorder.api.dto;

import java.time.Instant;

public class AccessOrderResponse {

    private final String orderId;
    private final String userId;
    private final String serviceName;
    private final String status;
    private final Instant createdAt;

    public AccessOrderResponse(
            String orderId,
            String userId,
            String serviceName,
            String status,
            Instant createdAt
    ) {
        this.orderId = orderId;
        this.userId = userId;
        this.serviceName = serviceName;
        this.status = status;
        this.createdAt = createdAt;
    }

    public String getOrderId() {
        return orderId;
    }

    public String getUserId() {
        return userId;
    }

    public String getServiceName() {
        return serviceName;
    }

    public String getStatus() {
        return status;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }
}