package com.caseflow.caseflow.repository;
import com.caseflow.caseflow.entity.ComplianceRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
@Repository
public interface ComplianceRecordRepository extends JpaRepository<ComplianceRecord,Integer>{
    List<ComplianceRecord> findByCaseId(Integer caseId);
    List<ComplianceRecord> findByResult(String result);
}
