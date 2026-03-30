package com.creditbureau.repository;

import com.creditbureau.entity.TradeLine;
import com.creditbureau.enums.TradeLineStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.*;
import java.math.BigDecimal;

@Repository
public interface TradeLineRepository extends JpaRepository<TradeLine, UUID> {
    @Query("""
           SELECT COALESCE(SUM(t.monthlyEmi), 0) 
           FROM TradeLine t 
           WHERE t.citizen.id = :citizenId 
           AND t.status = 'ACTIVE'
           """)
    BigDecimal sumActiveEmisByCitizenId(@Param("citizenId") UUID citizenId);
}


