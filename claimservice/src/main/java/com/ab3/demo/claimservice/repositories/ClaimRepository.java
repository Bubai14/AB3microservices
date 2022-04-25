package com.ab3.demo.claimservice.repositories;

import com.ab3.demo.claimservice.entities.ClaimDetails;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ClaimRepository extends CrudRepository<ClaimDetails, Integer> {

    List<ClaimDetails> findClaimDetailsByStatus(String status);

    @Override
    Optional<ClaimDetails> findById(Integer integer);

    @Override
    <S extends ClaimDetails> S save(S entity);
}
