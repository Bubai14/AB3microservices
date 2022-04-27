package com.ab3.demo.claimservice.services;

import com.ab3.demo.claimservice.dto.Claim;
import com.ab3.demo.claimservice.entities.ClaimDetails;
import com.ab3.demo.claimservice.messaging.MessageSender;
import com.ab3.demo.claimservice.repositories.ClaimRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClaimServiceImpl implements ClaimService{

    private ClaimRepository claimRepository;
    private MessageSender messageSender;

    @Autowired
    public ClaimServiceImpl(ClaimRepository claimRepository, MessageSender messageSender) {
        this.claimRepository = claimRepository;
        this.messageSender = messageSender;
    }

    @Override
    public Claim getClaim(Integer claimId) {
        return convertClaimDetailsEntityToDto(this.claimRepository.findById(claimId).get());
    }

    @Override
    public List<Claim> getUnapprovedClaims() {
        return this.claimRepository.findClaimDetailsByStatus("O").stream().
                map(claimDetails -> convertClaimDetailsEntityToDto(claimDetails)).collect(Collectors.toList());
    }

    @Override
    public boolean saveClaim(Claim claim) {
        if(claim == null) {
            // Log the message and throw the exception
        }
        ClaimDetails claimDetails = this.claimRepository.save(convertClaimDtoToEntity(claim));
        if(claimDetails.getClaimId() != null && claimDetails.getClaimId() > 0) {
            this.messageSender.send("Your claim for policy "+claimDetails.getPolicyNo()
                    +" has been recorded. We will updated you once status is changed. " +
                    "ETA 3 working days");
            return true;
        }
        return false;
    }

    @Override
    public boolean claimApproval(Integer claimId, String approval) {
        ClaimDetails claimDetails = this.claimRepository.findById(claimId).get();
        claimDetails.setStatus(approval);
        claimDetails = this.claimRepository.save(claimDetails);
        if(claimDetails.getClaimId() != null && claimDetails.getClaimId() > 0) {
            StringBuilder messageBuilder = new StringBuilder();
            messageBuilder.append("Your claim id ")
                    .append(claimDetails.getClaimId())
                    .append("for policy ")
                    .append(claimDetails.getPolicyNo())
                    .append(" has been ");
            if(approval.equals("A")) {
                messageBuilder.append("approved");
            } else {
                messageBuilder.append("rejected");
            }
            this.messageSender.send(messageBuilder.toString());
            return true;
        }
        return false;
    }

    private Claim convertClaimDetailsEntityToDto(ClaimDetails claimDetails) {
        Claim claim = new Claim(claimDetails.getClaimDate(), claimDetails.getPolicyNo(),
                claimDetails.getAmount(),
                claimDetails.getDamage(),
                claimDetails.getStatus());
        claim.setClaimId(claimDetails.getClaimId());
        return claim;
    }

    private ClaimDetails convertClaimDtoToEntity(Claim claim) {
        ClaimDetails claimDetails = new ClaimDetails(claim.getClaimDate(),
                claim.getPolicyNo(),
                claim.getAmount(),
                claim.getDamage(),
                claim.getStatus());
        if(claim.getClaimId() != null && claim.getClaimId() > 0) {
            claimDetails.setClaimId(claim.getClaimId());
        }
        return claimDetails;
    }
}
