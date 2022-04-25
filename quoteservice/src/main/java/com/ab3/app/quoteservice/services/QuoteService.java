package com.ab3.app.quoteservice.services;

import com.ab3.app.quoteservice.dto.Quote;
import org.springframework.stereotype.Service;

import java.util.List;


public interface QuoteService {

    public Quote getQuote(Integer coverage, Integer term);

    public List<Quote> getQuotes(QuoteParam quoteParam, Integer val);

}
