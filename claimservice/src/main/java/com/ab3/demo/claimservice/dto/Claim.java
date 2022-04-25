package com.ab3.demo.claimservice.dto;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Claim {

    private Integer claimId;
    @NonNull
    private String claimDate;
    @NonNull
    private String policyNo;
    @NonNull
    private Integer amount;
    @NonNull
    private String damage;
    @NonNull
    private String status;
}
