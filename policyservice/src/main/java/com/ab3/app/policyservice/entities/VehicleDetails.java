package com.ab3.app.policyservice.entities;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@RequiredArgsConstructor
@Entity
@Table(name = "vehicle_details")
public class VehicleDetails {
    @Id
    @Column(name = "vehicle_id")
    private Integer vehicleId;

    @NonNull
    @Column(name = "make")
    private String make;

    @NonNull
    @Column(name = "model")
    private String model;

    @NonNull
    @Column(name = "reg_no")
    private String regNo;

    @NonNull
    @Column(name = "chassis_no")
    private String chassisNo;

    @NonNull
    @Column(name = "cc")
    private Integer cc;
}
