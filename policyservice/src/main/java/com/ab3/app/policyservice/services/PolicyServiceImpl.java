package com.ab3.app.policyservice.services;

import com.ab3.app.policyservice.dto.Policy;
import com.ab3.app.policyservice.entities.PolicyDetails;
import com.ab3.app.policyservice.entities.PolicyType;
import com.ab3.app.policyservice.entities.VehicleDetails;
import com.ab3.app.policyservice.repositories.PolicyRepository;
import com.ab3.app.policyservice.repositories.PolicyTypeRepository;
import com.ab3.app.policyservice.repositories.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class PolicyServiceImpl implements PolicyService {

    private PolicyTypeRepository policyTypeRepository;
    private VehicleRepository vehicleRepository;
    private PolicyRepository policyRepository;

    @Autowired
    public PolicyServiceImpl(PolicyTypeRepository policyTypeRepository,
                             VehicleRepository vehicleRepository,
                             PolicyRepository policyRepository) {
        this.policyRepository = policyRepository;
        this.vehicleRepository = vehicleRepository;
        this.policyTypeRepository = policyTypeRepository;
    }

    @Override
    public List<Policy> getAllPolicies() {
        return this.policyRepository.findAllByPolicyActIndEquals("Y").stream().
                map(policyDetails -> convertPolicyEntityToDto(policyDetails)).
                collect(Collectors.toList());
    }

    @Override
    public boolean savePolicy(Policy policy) {
        if(null == policy) {
            // Log the error and throw the message back to the user.
        }
        PolicyDetails policyDetails =  this.policyRepository.save(convertPolicyDtoToEntity(policy));
        if(policyDetails.getPolicyId() == null || policyDetails.getPolicyId().equals(0)) {
            // Log the message and throw the error
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }

    @Override
    public Policy getPolicy(Integer policyId) {
        return convertPolicyEntityToDto(this.policyRepository.findById(policyId).get());
    }

    @Override
    public List<PolicyType> getPolicyTypes() {
        return StreamSupport.
                stream(policyTypeRepository.findAll().spliterator(), false).
                collect(Collectors.toList());
    }

    private Policy convertPolicyEntityToDto(PolicyDetails policyDetails) {
        return new Policy(policyDetails.getPolicyNo(),
                policyDetails.getPolicyType().getPolicyTypeId(),
                policyDetails.getPolicyIssueDate(),
                policyDetails.getInsuredName(),
                policyDetails.getInsuredAddress(),
                policyDetails.getPeriodOfInsurance(),
                policyDetails.getPolicyActInd(),
                policyDetails.getInsuredEmail(),
                policyDetails.getInsuredPhone(),
                policyDetails.getVehicleDetails().getMake(),
                policyDetails.getVehicleDetails().getModel(),
                policyDetails.getVehicleDetails().getRegNo(),
                policyDetails.getVehicleDetails().getChassisNo(),
                policyDetails.getVehicleDetails().getCc());
    }

    private PolicyDetails convertPolicyDtoToEntity(Policy policy) {
        PolicyType policyType = this.policyTypeRepository.findById(policy.getPolicyType()).get();
        VehicleDetails vehicleDetails = new VehicleDetails(policy.getMake(),
                policy.getModel(),
                policy.getRegNo(),
                policy.getChassisNo(),
                policy.getCc());
        return new PolicyDetails(policy.getPolicyNo(),
                policyType,
                policy.getPolicyIssueDate(),
                policy.getInsuredName(),
                policy.getInsuredAddress(),
                policy.getPeriodOfInsurance(),
                vehicleDetails,
                "Y",
                policy.getInsuredEmail(),
                policy.getInsuredPhone());
    }
}
