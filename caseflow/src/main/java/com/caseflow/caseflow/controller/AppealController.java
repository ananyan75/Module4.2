package com.caseflow.caseflow.controller;
import com.caseflow.caseflow.entity.Appeal;
import com.caseflow.caseflow.service.AppealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/appeals")
public class AppealController {
    @Autowired
    private AppealService appealService;

    @PostMapping
    public ResponseEntity<Appeal> fileAppeal(
            @RequestBody Appeal appeal){
        return ResponseEntity.ok(
                appealService.fileAppeal(appeal));
    }
    @GetMapping("/case/{caseId}")
    public ResponseEntity<List<Appeal>> getByCase(
            @PathVariable Integer caseId){
        return ResponseEntity.ok(
                appealService.getAppealsByCase(caseId));
    }
    @PostMapping("/{appealId}/status")
    public ResponseEntity<Appeal> updateStatus(
            @PathVariable Integer appealId,
            @RequestParam String status){
        return ResponseEntity.ok(
                appealService.updateAppealStatus(appealId,status));
    }
}
