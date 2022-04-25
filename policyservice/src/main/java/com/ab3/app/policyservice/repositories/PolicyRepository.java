package com.ab3.app.policyservice.repositories;

import com.ab3.app.policyservice.entities.PolicyDetails;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Exposes the methods to perform the database operations on the {@code policy_details} table.
 * {@code policy_details} table stores all the policy information for all the customers buying
 * policy from the insurance company.
 */
@Repository
public interface PolicyRepository extends CrudRepository<PolicyDetails, Integer> {

    /**
     * Finds active and inactive policies based on passed parameter.<br>
     * For active policies pass 'Y' or 'y'
     * For inactive policies pass 'N' or 'n'
     * @param policyActInd the indicator to decide the type of policies to be retrieved.
     * @return the list of policies
     */
    List<PolicyDetails> findAllByPolicyActIndEquals(String policyActInd);

    @Override
    <S extends PolicyDetails> S save(S entity);

    @Override
    Iterable<PolicyDetails> findAll();

    @Override
    Optional<PolicyDetails> findById(Integer integer);
}
