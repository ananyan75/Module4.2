package com.caseflow.caseflow.service;
import com.caseflow.caseflow.entity.*;
import com.caseflow.caseflow.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class HearingService {
    @Autowired
    private HearingRepository hearingRepository;
    @Autowired
    private CasesRepository casesRepository;
    @Autowired
    private AuditLogService auditLogService;
    @Autowired
    private NotificationService notificationService;
    public Hearing scheduleHearing(Hearing hearing){
        Cases c=casesRepository.findById(hearing.getCaseId()).orElseThrow(()->new RuntimeException("Case not found"));
        if(!"Active".equals(c.getStatus())){
            throw new RuntimeException(
                    "Case must be Active to schedule a hearing"
            );
        }
        hearing.setStatus("Scheduled");
        Hearing saved=hearingRepository.save(hearing);

        auditLogService.log(
                null,
                "HEARING_SCHEDULED",
                "Hearing#"+saved.getHearingId()
        );
        notificationService.send(
                c.getLitigantId(),
                c.getCaseId(),
                "A hearing has been scheduled for your case.",
                "Hearing"
        );
        return saved;
    }
    public Hearing rescheduleHearing(Integer hearingId,Hearing updated){
        Hearing existing=hearingRepository.findById(hearingId).orElseThrow(()->new RuntimeException("Hearing not found"));
        existing.setDate(updated.getDate());
        existing.setTime(updated.getTime());
        existing.setStatus("Rescheduled");
        Hearing saved=hearingRepository.save(existing);
        auditLogService.log(
                null,
                "HEARING_RESCHEDULED",
                "Hearing#"+hearingId
        );
        return saved;

    }
    public List<Hearing> getHearingsByCase(Integer caseId){
        return hearingRepository.findByCaseId(caseId);
    }
}
