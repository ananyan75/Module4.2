package com.caseflow.caseflow.controller;
import com.caseflow.caseflow.entity.Report;
import com.caseflow.caseflow.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/reports")
public class ReportController {
    @Autowired
    private ReportService reportService;
    @PostMapping
    public ResponseEntity<Report> generate(
            @RequestParam String scope) {
        return ResponseEntity.ok(
                reportService.generateReport(scope));
    }
        @GetMapping
        public ResponseEntity<List<Report>> getAll(){
            return ResponseEntity.ok(
                   reportService.getAllReports());

    }
}
