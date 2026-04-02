package com.creditbureau.dto.response;

import lombok.Builder;
import lombok.Data;
import java.math.BigDecimal;

@Data
@Builder
public class BureauResponse {
    private String panNumber;
    private BigDecimal totalMonthlyEmi;
//    private Integer creditScore;
    private boolean found;
}