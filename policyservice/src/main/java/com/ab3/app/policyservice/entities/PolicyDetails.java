package com.ab3.app.policyservice.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Data
@RequiredArgsConstructor
@Entity
@Table(name = "policy_details")
public class PolicyDetails {
    @Id
    @Column(name = "policy_id")
    private Integer policyId;

    @NonNull
    @Column(name = "policy_no")
    private String policyNo;

    @NonNull
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "policy_type_id")
    private PolicyType policyType;

    @NonNull
    @Column(name = "policy_issue_date")
    private String policyIssueDate;

    @NonNull
    @Column(name = "insured_name")
    private String insuredName;

    @NonNull
    @Column(name = "insured_address")
    private String insuredAddress;

    @NonNull
    @Column(name = "period_of_insurance")
    private Integer periodOfInsurance;

    @NonNull
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "vehicle_id")
    private VehicleDetails vehicleDetails;

    @NonNull
    @Column(name = "policy_act_ind")
    private String policyActInd;

    @NonNull
    @Column(name = "insured_email")
    private String insuredEmail;

    @NonNull
    @Column(name = "insured_phone")
    private String insuredPhone;

    public PolicyDetails() {

    }
}
