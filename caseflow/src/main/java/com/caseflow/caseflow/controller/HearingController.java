package com.caseflow.caseflow.controller;
import com.caseflow.caseflow.entity.Hearing;
import com.caseflow.caseflow.service.HearingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.*;
@RestController
@RequestMapping("/api/v1/hearings")
public class HearingController {
    @Autowired
    private HearingService hearingService;

    @PostMapping
    public ResponseEntity<Hearing> schedule(
            @RequestBody Hearing hearing){
        return ResponseEntity.ok(
                hearingService.scheduleHearing(hearing));
    }
    @GetMapping("/case/{caseId}")
    public ResponseEntity<List<Hearing>> getByCase(
            @PathVariable Integer caseId){
        return ResponseEntity.ok(
                hearingService.getHearingsByCase(caseId));
    }
    @PatchMapping("/{hearingId}/reschedule")
    public ResponseEntity<Hearing> reschedule(
            @PathVariable Integer hearingId,
            @RequestBody Hearing updated){
        return ResponseEntity.ok(
                hearingService.rescheduleHearing(hearingId,updated));
    }
}
