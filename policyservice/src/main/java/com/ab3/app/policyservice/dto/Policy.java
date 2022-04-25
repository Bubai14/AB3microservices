package com.ab3.app.policyservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Policy {

    private String policyNo;
    private Integer policyType;
    private String policyIssueDate;
    private String insuredName;
    private String insuredAddress;
    private Integer periodOfInsurance;
    private String policyActInd;
    private String insuredEmail;
    private String insuredPhone;
    private String make;
    private String model;
    private String regNo;
    private String chassisNo;
    private Integer cc;
}
