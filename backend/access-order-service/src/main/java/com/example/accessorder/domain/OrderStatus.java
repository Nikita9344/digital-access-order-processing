package com.example.accessorder.domain;
//You can use an Enum type when you need a fixed set of pre-defined constant values that are
// known at the compile-time itself. Examples can be days of the week, seasons of the year, etc.
//will be used in API, DB, wfl
public enum OrderStatus {

    PENDING,
    VALIDATING,
    PROCESSING,
    APPROVED,
    REJECTED
}