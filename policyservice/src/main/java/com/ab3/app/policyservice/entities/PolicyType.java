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
@Table(name = "policy_type")
public class PolicyType {
    @Id
    @Column(name = "policy_type_id")
    private Integer policyTypeId;

    @NonNull
    @Column(name = "policy_type_name")
    private String policyTypeName;

    @NonNull
    @Column(name = "policy_type_act_ind")
    private String policyTypeActInd;

    public PolicyType() {

    }
}
