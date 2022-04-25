package com.ab3.app.quoteservice.repositories;

import com.ab3.app.quoteservice.entities.QuoteMaster;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface QuoteRepository extends CrudRepository<QuoteMaster, Integer> {

    @Override
    Iterable<QuoteMaster> findAll();

    @Override
    Optional<QuoteMaster> findById(Integer integer);

    QuoteMaster findQuoteMasterByCoverageAndTerm(Integer coverage, Integer term);

    List<QuoteMaster> findQuoteMasterByCoverage(Integer coverage);

    List<QuoteMaster> findQuoteMasterByTerm(Integer term);
}
