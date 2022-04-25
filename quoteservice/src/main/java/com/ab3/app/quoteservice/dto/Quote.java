package com.ab3.app.quoteservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class Quote {

    private Integer coverage;
    private Integer term;
    private BigDecimal premium;
}
