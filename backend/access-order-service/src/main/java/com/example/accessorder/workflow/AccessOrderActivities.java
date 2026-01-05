package com.example.accessorder.workflow;

import io.temporal.activity.ActivityInterface;
import io.temporal.activity.ActivityMethod;

@ActivityInterface
public interface AccessOrderActivities {

    @ActivityMethod
    void validateOrder(String orderId);

    @ActivityMethod
    void approveOrder(String orderId);
}