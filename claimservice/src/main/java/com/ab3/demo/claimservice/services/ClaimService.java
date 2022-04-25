package com.ab3.demo.claimservice.services;

import com.ab3.demo.claimservice.dto.Claim;
import org.springframework.stereotype.Service;

import java.util.List;


public interface ClaimService {

    public Claim getClaim(Integer claimId);

    public List<Claim> getUnapprovedClaims();

    public boolean saveClaim(Claim claim);
}
