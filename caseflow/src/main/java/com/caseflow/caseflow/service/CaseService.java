package com.caseflow.caseflow.service;
import com.caseflow.caseflow.entity.*;
import com.caseflow.caseflow.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.time.LocalDate;
import java.util.List;
@Service
public class CaseService {
    @Autowired
    private CasesRepository casesRepository;
    @Autowired
    private WorkflowStageRepository workflowStageRepository;
    @Autowired
    private SLARecordRepository slaRecordRepository;
    @Autowired
    private AuditLogService auditLogService;
    @Autowired
    private NotificationService notificationService;
    public Cases fileCase(Cases newCase){
        newCase.setFiledDate(LocalDateTime.now());
        newCase.setStatus("Filed");
        Cases saved=casesRepository.save(newCase);
        WorkflowStage stage=new WorkflowStage();
        stage.setCaseId(saved.getCaseId());
        stage.setSequenceNumber(1);
        stage.setRoleResponsible("Clerk");
        stage.setSla_Days(3);
        WorkflowStage savedStage=workflowStageRepository.save(stage);
        SLARecord sla=new SLARecord();
        sla.setCaseId(saved.getCaseId());
        sla.setStageId(savedStage.getStageId());
        sla.setStartDate(LocalDate.now());
        sla.setStatus("OnTime");
        slaRecordRepository.save(sla);

        auditLogService.log(
                saved.getLitigantId(),
                "CASE_FILED",
                "Case#" + saved.getCaseId()
        );

        notificationService.send(
                saved.getLitigantId(),
                saved.getCaseId(),
                "Your case has been filed successfully.",
                "Case"
        );
        return saved;
    }
    public List<Cases> getCasesByLitigant(Integer litigantId){
        return casesRepository.findByLitigantId(litigantId);
    }
    public List<Cases> getCasesByLawyer(Integer lawyerId){
        return casesRepository.findByLawyerId(lawyerId);
    }
    public Cases getCaseById(Integer caseId){
        return casesRepository.findById(caseId).orElseThrow(()->new RuntimeException("Case not found"));
    }
    public Cases updateStatus(Integer caseId,String newStatus){
        Cases existing=getCaseById(caseId);
        existing.setStatus(newStatus);
        Cases updated=casesRepository.save(existing);

        auditLogService.log(
                null,
                "CASE_STATUS_UPDATED",
                "Case#"+caseId+"->"+newStatus
        );
        return updated;
    }
}
