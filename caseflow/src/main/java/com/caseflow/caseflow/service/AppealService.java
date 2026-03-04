package com.caseflow.caseflow.service;
import com.caseflow.caseflow.entity.*;
import com.caseflow.caseflow.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;
@Service
public class AppealService {
    @Autowired
    private AppealRepository appealRepository;
    @Autowired
    private CasesRepository casesRepository;
    @Autowired
    private AuditLogService auditLogService;
    @Autowired
    private NotificationService notificationService;
    public Appeal fileAppeal(Appeal appeal){
        Cases c=casesRepository.findById(appeal.getCaseId()).orElseThrow(()->new RuntimeException("Case not found"));
        if(!"Closed".equals(c.getStatus())){
            throw new RuntimeException("Appeal can only be filed on a Closed case");
        }
        appeal.setFiledDate(LocalDate.now());
        appeal.setStatus("Submitted");
        Appeal saved=appealRepository.save(appeal);
        auditLogService.log(
                null,
                "APPEAL_FILED",
                "Appeal#"+saved.getAppealId()
        );
        return saved;
    }
    public Appeal updateAppealStatus(Integer appealId,String status){
        Appeal appeal=appealRepository.findById(appealId).orElseThrow(()->new RuntimeException("Appeal not found"));
        appeal.setStatus(status);
        return appealRepository.save(appeal);
    }
    public List<Appeal> getAppealsByCase(Integer caseId){
        return appealRepository.findByCaseId(caseId);
    }
}
