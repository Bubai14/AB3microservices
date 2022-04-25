package com.ab3.app.policyservice.services;

import com.ab3.app.policyservice.dto.Policy;
import com.ab3.app.policyservice.entities.PolicyType;
import org.springframework.stereotype.Service;

import java.util.List;


public interface PolicyService {

    public List<Policy> getAllPolicies();

    public boolean savePolicy(Policy policy);

    public Policy getPolicy(Integer policyId);

    public List<PolicyType> getPolicyTypes();
}
