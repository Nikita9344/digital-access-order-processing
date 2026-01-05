package com.example.accessorder.domain;

import java.time.Instant;
import java.util.UUID;

public class AccessOrder {

    private final String orderId;
    private final String userId;
    private final String serviceName;

    private OrderStatus status;
    private final Instant createdAt;
    private Instant updatedAt;

    AccessOrder(
            String orderId,
            String userId,
            String serviceName,
            OrderStatus status,
            Instant createdAt,
            Instant updatedAt
    ) {
        this.orderId = orderId;
        this.userId = userId;
        this.serviceName = serviceName;
        this.status = status;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public static AccessOrder fromPersistence(
            String orderId,
            String userId,
            String serviceName,
            OrderStatus status,
            Instant createdAt,
            Instant updatedAt
    ) {
        return new AccessOrder(
                orderId,
                userId,
                serviceName,
                status,
                createdAt,
                updatedAt
        );
    }

    public static AccessOrder createNew(String userId, String serviceName) {
        Instant now = Instant.now();
        return new AccessOrder(
                UUID.randomUUID().toString(),
                userId,
                serviceName,
                OrderStatus.PENDING,
                now,
                now
        );
    }



    public void updateStatus(OrderStatus newStatus) {
        this.status = newStatus;
        this.updatedAt = Instant.now();
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

    public OrderStatus getStatus() {
        return status;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }
}