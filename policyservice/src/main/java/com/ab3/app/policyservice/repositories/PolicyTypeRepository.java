package com.ab3.app.policyservice.repositories;

import com.ab3.app.policyservice.entities.PolicyType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Exposes the methods to perform the database operations on the {@code policy_type} table.
 * {@code policy_type} table stores all the policy types sold by the insurance company.
 */
@Repository
public interface PolicyTypeRepository extends CrudRepository<PolicyType, Integer> {

    @Override
    Iterable<PolicyType> findAll();

    @Override
    Optional<PolicyType> findById(Integer integer);
}
