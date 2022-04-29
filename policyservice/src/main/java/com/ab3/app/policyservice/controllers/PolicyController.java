package com.ab3.app.policyservice.controllers;

import com.ab3.app.policyservice.dto.Policy;
import com.ab3.app.policyservice.entities.PolicyType;
import com.ab3.app.policyservice.services.PolicyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("policy")
public class PolicyController {

    @Autowired
    private PolicyService policyService;

    @Autowired
    public PolicyController(PolicyService policyService) {
        this.policyService = policyService;
    }

    @GetMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Policy>> getAllPolicies() {
        return ResponseEntity.ok(this.policyService.getAllPolicies());
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Policy> getPolicy(@PathVariable("id") Integer policyId) {
        return ResponseEntity.ok(this.policyService.getPolicy(policyId));
    }

    @PostMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Boolean> savePolicy(@RequestBody Policy policy){
        return ResponseEntity.ok(this.policyService.savePolicy(policy));
    }

    @GetMapping(value = "/types", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<PolicyType>> getAllPolicyTypes() {
        return ResponseEntity.ok(this.policyService.getPolicyTypes());
    }
}
