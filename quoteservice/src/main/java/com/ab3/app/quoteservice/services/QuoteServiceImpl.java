package com.ab3.app.quoteservice.services;

import com.ab3.app.quoteservice.dto.Quote;
import com.ab3.app.quoteservice.entities.QuoteMaster;
import com.ab3.app.quoteservice.repositories.QuoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class QuoteServiceImpl implements QuoteService{

    private QuoteRepository quoteRepository;

    @Autowired
    public QuoteServiceImpl(QuoteRepository quoteRepository) {
        this.quoteRepository = quoteRepository;
    }

    @Override
    public Quote getQuote(Integer coverage, Integer term) {
        return convertQuoteEntityToDto(
                this.quoteRepository.findQuoteMasterByCoverageAndTerm(coverage, term));
    }

    @Override
    public List<Quote> getQuotes(QuoteParam quoteParam, Integer val) {
        if(quoteParam.equals(QuoteParam.COVERAGE)) {
            return getQuotesByCoverage(val);
        } else {
            return getQuotesByTerm(val);
        }
    }

    private List<Quote> getQuotesByCoverage(Integer coverage) {
        return this.quoteRepository.findQuoteMasterByCoverage(coverage).stream().
                map(quoteMaster -> convertQuoteEntityToDto(quoteMaster)).collect(Collectors.toList());
    }

    private List<Quote> getQuotesByTerm(Integer term) {
        return this.quoteRepository.findQuoteMasterByTerm(term).stream().
                map(quoteMaster -> convertQuoteEntityToDto(quoteMaster)).collect(Collectors.toList());
    }

    private Quote convertQuoteEntityToDto(QuoteMaster quoteMaster) {
        return new Quote(quoteMaster.getCoverage(),
                quoteMaster.getTerm(),
                quoteMaster.getPremium());
    }
}
