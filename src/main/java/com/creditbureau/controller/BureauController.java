package com.creditbureau.controller;

import com.creditbureau.dto.request.BureauRequest;
import com.creditbureau.dto.response.BureauResponse;
import com.creditbureau.service.BureauReportService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api/v1/credit")
@RequiredArgsConstructor
public class BureauController {

    private final BureauReportService bureauReportService;

    @GetMapping("/report")
    public ResponseEntity<BureauResponse> getCreditReport(@RequestParam("panNumber") String panNumber) {
        BureauResponse response = bureauReportService.generateReport(panNumber);
        return ResponseEntity.ok(response);
    }
}