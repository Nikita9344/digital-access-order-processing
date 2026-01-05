package com.example.accessorder.persistence;

import jakarta.persistence.*;
import java.time.Instant;

//We will NOT annotate AccessOrder with @Entity.
//
//        Why?
//        •	Domain model ≠ database model
//	•	JPA annotations leak persistence concerns
//	•	Harder to test
//	•	Interview red flag in senior reviews
//
//✅ What we WILL do
//
//We will:
//        •	Keep AccessOrder pure domain
//	•	Create a separate AccessOrderEntity
//	•	Explicitly map between them

@Entity
@Table(name = "access_orders")
public class AccessOrderEntity {

    @Id
    @Column(name = "order_id", nullable = false)
    private String orderId;

    @Column(name = "user_id", nullable = false)
    private String userId;

    @Column(name = "service_name", nullable = false)
    private String serviceName;

    @Column(name = "status", nullable = false)
    private String status;

    @Column(name = "created_at", nullable = false)
    private Instant createdAt;

    @Column(name = "updated_at", nullable = false)
    private Instant updatedAt;

    protected AccessOrderEntity() {
        // Required by JPA
    }

    public AccessOrderEntity(
            String orderId,
            String userId,
            String serviceName,
            String status,
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

    public Instant getUpdatedAt() {
        return updatedAt;
    }
}

