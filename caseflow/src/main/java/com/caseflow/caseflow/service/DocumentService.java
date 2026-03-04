package com.caseflow.caseflow.service;
import com.caseflow.caseflow.entity.*;
import com.caseflow.caseflow.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;
@Service
public class DocumentService {
    @Autowired
    private DocumentRepository documentRepository;
    @Autowired
    private CasesRepository casesRepository;
    @Autowired
    private AuditLogService auditLogService;
    @Autowired
    private NotificationService notificationService;
    public Document uploadDocument(Document doc){
        doc.setUploadedDate(LocalDateTime.now());
        doc.setVerificationStatus("Pending");
        Document saved=documentRepository.save(doc);
        auditLogService.log(
                null,
                "DOCUMENT_UPLOADED",
                "Doc#" +saved.getDocumentId()
        );
        return saved;
    }
    public List<Document> getDocumentsByCase(Integer caseId){
        return documentRepository.findByCaseId(caseId);
    }
    public Document verifyDocument(Integer documentId,String status,Integer clerkId){
        Document doc=documentRepository.findById(documentId).orElseThrow(()->new RuntimeException("Document not found"));
        doc.setVerificationStatus(status);
        documentRepository.save(doc);
        auditLogService.log(
                clerkId,
                "DOCUMENT_"+status.toUpperCase(),
                "Doc#"+documentId
        );
        List<Document> allDocs=documentRepository.findByCaseId(doc.getCaseId());
        boolean allVerified=allDocs.stream().allMatch(
                d->"Verified".equals(d.getVerificationStatus())
        );
        if(allVerified){
            Cases c=casesRepository.findById(doc.getCaseId()).orElseThrow();
            c.setStatus("Active");
            casesRepository.save(c);
            auditLogService.log(
                    clerkId,
                    "CASE_ACTIVE",
                    "Case#"+doc.getCaseId()
            );
        }
        return doc;
    }
}
