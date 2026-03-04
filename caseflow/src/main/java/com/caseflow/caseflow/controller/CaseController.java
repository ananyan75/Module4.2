package com.caseflow.caseflow.controller;
import com.caseflow.caseflow.entity.Cases;
import com.caseflow.caseflow.service.CaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.*;
@RestController
@RequestMapping("/api/v1/cases")
public class CaseController {
    @Autowired
    private CaseService caseService;

    @PostMapping
    public ResponseEntity<Cases> fileCase(@RequestBody Cases newCase){
        return ResponseEntity.ok(caseService.fileCase(newCase));
    }
    @GetMapping("/{caseId}")
    public ResponseEntity<Cases> getCase(
            @PathVariable Integer caseId){
        return ResponseEntity.ok(
                caseService.getCaseById(caseId));
    }
    @GetMapping("/lawyer/{lawyerId}")
    public ResponseEntity<List<Cases>> getLawyerCases(
            @PathVariable Integer lawyerId){
        return ResponseEntity.ok(
                caseService.getCasesByLawyer(lawyerId));
    }
    @PutMapping("/{caseId}/status")
    public ResponseEntity<Cases> updateStatus(
            @PathVariable Integer caseId,
            @RequestParam String status){
        return ResponseEntity.ok(
                caseService.updateStatus(caseId,status));
    }

}
