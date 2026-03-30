package com.creditbureau.service;

import com.creditbureau.dto.request.BureauRequest;
import com.creditbureau.dto.response.BureauResponse;
import com.creditbureau.entity.Citizen;
import com.creditbureau.repository.CitizenRepository;
import com.creditbureau.repository.TradeLineRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class BureauReportService {

    private final CitizenRepository citizenRepository;
    private final TradeLineRepository tradeLineRepository;

    @Transactional(readOnly = true)
    public BureauResponse generateReport(BureauRequest request) {
        log.info("Generating report for PAN: {}", request.getPanNumber());

        Optional<Citizen> citizenOpt = citizenRepository.findByPanNumber(request.getPanNumber());

        if (citizenOpt.isEmpty()) {
            log.warn("Citizen not found in Bureau database for PAN: {}", request.getPanNumber());
            return BureauResponse.builder()
                    .panNumber(request.getPanNumber())
                    .totalMonthlyEmi(BigDecimal.ZERO)
                    .found(false)
                    .build();
        }

        Citizen citizen = citizenOpt.get();
        BigDecimal totalActiveEmi = tradeLineRepository.sumActiveEmisByCitizenId(citizen.getId());

        return BureauResponse.builder()
                .panNumber(citizen.getPanNumber())
                .totalMonthlyEmi(totalActiveEmi)
//                .creditScore(citizen.getCreditScore())
                .found(true)
                .build();
    }
}