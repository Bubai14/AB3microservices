package com.ab3.demo.claimservice.controllers;

import com.ab3.demo.claimservice.dto.Claim;
import com.ab3.demo.claimservice.services.ClaimService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("claim")
public class ClaimController {

    @Autowired
    private ClaimService claimService;

    @Autowired
    public ClaimController(ClaimService claimService) {
        this.claimService = claimService;
    }

    @GetMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE )
    public ResponseEntity<List<Claim>> getUnapprovedClaims() {
        return ResponseEntity.ok(this.claimService.getUnapprovedClaims());
    }

    @PostMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Boolean> saveClaim(@RequestBody Claim claim) {
        return ResponseEntity.ok(this.claimService.saveClaim(claim));
    }

    @PutMapping(value = "/approval/{claimId}/{approval}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Boolean> claimApproval(@PathVariable("claimId") Integer claimId, @PathVariable("approval") String approval) {
        return ResponseEntity.ok(this.claimService.claimApproval(claimId, approval));
    }
}
