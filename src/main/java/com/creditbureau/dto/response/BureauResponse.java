package com.creditbureau.dto.response;

import lombok.Builder;
import lombok.Data;
import java.math.BigDecimal;

@Data
@Builder
public class BureauResponse {
    private String panNumber;
    private BigDecimal totalMonthlyEmi;
//    private Integer creditScore; // Added this so it's a realistic bureau response
    private boolean found;
}