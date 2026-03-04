package com.caseflow.caseflow.service;
import com.caseflow.caseflow.entity.AuditLog;
import com.caseflow.caseflow.repository.AuditLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
@Service
public class AuditLogService {
    @Autowired
    private AuditLogRepository auditLogRepository;
    public void log(Integer userId,String action,String resource){
        AuditLog log=new AuditLog();
        log.setUserId(userId);
        log.setAction(action);
        log.setResource(resource);
        log.setTimestamp(LocalDateTime.now());
        auditLogRepository.save(log);
    }
}
