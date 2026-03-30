package com.creditbureau.entity;

import com.creditbureau.enums.TradeLineStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "trade_lines")
@Getter @Setter @NoArgsConstructor
public class TradeLine {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "citizen_id", nullable = false)
    private Citizen citizen;

    @Column(nullable = false)
    private String bankName;

    @Column(nullable = false, precision = 15, scale = 2)
    private BigDecimal loanAmount;

    @Column(nullable = false, precision = 15, scale = 2)
    private BigDecimal monthlyEmi;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TradeLineStatus status;
}