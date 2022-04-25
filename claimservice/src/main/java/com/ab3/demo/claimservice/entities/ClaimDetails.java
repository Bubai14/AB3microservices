package com.ab3.demo.claimservice.entities;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Data
@RequiredArgsConstructor
@Entity
@Table(name = "claim_details")
public class ClaimDetails {
    @Id
    @Column(name = "claim_id")
    private Integer claimId;

    @NonNull
    @Column(name = "claim_date")
    private String claimDate;

    @NonNull
    @Column(name = "policy_no")
    private String policyNo;

    @NonNull
    @Column(name = "amount")
    private Integer amount;

    @NonNull
    @Column(name = "damage")
    private String damage;

    @NonNull
    @Column(name = "status")
    private String status;

    public ClaimDetails() {

    }
}
