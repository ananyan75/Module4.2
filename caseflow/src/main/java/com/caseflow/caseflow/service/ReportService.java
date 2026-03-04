package com.caseflow.caseflow.service;
import com.caseflow.caseflow.entity.Report;
import com.caseflow.caseflow.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;
@Service
public class ReportService {
    @Autowired
    private ReportRepository reportRepository;

    @Autowired
    private CasesRepository casesRepository;

    @Autowired
    private DocumentRepository documentRepository;

    public Report generateReport(String scope){
        long filed=casesRepository.findByStatus("Filed").size();
        long active=casesRepository.findByStatus("Active").size();
        long closed=casesRepository.findByStatus("Closed").size();
        long verified=documentRepository.findByCaseIdAndVerificationStatus(0,"Verified").size();
        String metrics="Filed="+filed+", Active="+active+", Closed="+closed;
        Report report=new Report();
        report.setScope(scope);
        report.setMetrics(metrics);
        report.setGeneratedDate(LocalDate.now());
        return reportRepository.save(report);
    }
    public List<Report> getAllReports(){
        return reportRepository.findAll();
    }
}
