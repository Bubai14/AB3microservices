package com.ab3.app.quoteservice.entities;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Data
@RequiredArgsConstructor
@Table(name = "quote_master")
public class QuoteMaster {
    @Id
    @Column(name = "quote_id")
    private Integer quoteId;

    @NonNull
    @Column(name = "coverage")
    private Integer coverage;

    @NonNull
    @Column(name = "term")
    private Integer term;

    @NonNull
    @Column(name = "premium")
    private BigDecimal premium;

    public QuoteMaster() {

    }
}
