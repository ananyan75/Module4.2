package com.caseflow.caseflow.repository;
import com.caseflow.caseflow.entity.SLARecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
@Repository
public interface SLARecordRepository extends JpaRepository<SLARecord,Integer>{
    List<SLARecord> findByCaseId(Integer caseId);
    List<SLARecord> findByStatus(String status);
}
