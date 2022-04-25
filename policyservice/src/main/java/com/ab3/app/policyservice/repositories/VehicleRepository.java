package com.ab3.app.policyservice.repositories;

import com.ab3.app.policyservice.entities.VehicleDetails;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Exposes the methods to perform the database operations on the {@code vehicle_details} table.
 * {@code vehicle_details} table stores all the vehicle information for which the policy is purchased.
 */
@Repository
public interface VehicleRepository extends CrudRepository<VehicleDetails, Integer> {

    @Override
    <S extends VehicleDetails> S save(S entity);

    @Override
    Optional<VehicleDetails> findById(Integer integer);
}
