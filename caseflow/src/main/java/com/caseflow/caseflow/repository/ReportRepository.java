package com.caseflow.caseflow.repository;
import com.caseflow.caseflow.entity.Report;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
@Repository
public interface ReportRepository extends JpaRepository<Report,Integer>{
    List<Report> findByScope(String scope);
}
