package com.example.accessorder.api.dto;

public class CreateAccessOrderRequest {

    private String userId;
    private String serviceName;


    public CreateAccessOrderRequest() {
    }

    public String getUserId() {
        return userId;
    }

    public String getServiceName() {
        return serviceName;
    }
}