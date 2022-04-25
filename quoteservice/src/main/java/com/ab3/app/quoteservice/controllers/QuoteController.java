package com.ab3.app.quoteservice.controllers;

import com.ab3.app.quoteservice.dto.Quote;
import com.ab3.app.quoteservice.services.QuoteParam;
import com.ab3.app.quoteservice.services.QuoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("quote")
public class QuoteController {

    @Autowired
    private QuoteService quoteService;

    @Autowired
    public QuoteController(QuoteService quoteService) {
        this.quoteService = quoteService;
    }

    @GetMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Quote> getQuote(@RequestParam("coverage") Integer coverage, @RequestParam("term") Integer term) {
        return ResponseEntity.ok(this.quoteService.getQuote(coverage, term));
    }

    @GetMapping(value = "/coverage/{coverage}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Quote>> getQuotesByCoverage(@PathVariable("coverage") Integer coverage) {
        return ResponseEntity.ok(this.quoteService.getQuotes(QuoteParam.COVERAGE, coverage));
    }

    @GetMapping(value = "/term/{term}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Quote>> getQuotesByTerm(@PathVariable("term") Integer term) {
        return ResponseEntity.ok(this.quoteService.getQuotes(QuoteParam.TERM, term));
    }
}
