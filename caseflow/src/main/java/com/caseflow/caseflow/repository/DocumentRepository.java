package com.caseflow.caseflow.repository;
import com.caseflow.caseflow.entity.Document;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
@Repository
public interface DocumentRepository extends JpaRepository<Document,Integer>{
    List<Document> findByCaseId(Integer caseId);
    List<Document> findByCaseIdAndVerificationStatus(Integer caseId,String status);
}
