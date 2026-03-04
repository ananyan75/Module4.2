package com.caseflow.caseflow.repository;
import com.caseflow.caseflow.entity.WorkflowStage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
@Repository
public interface WorkflowStageRepository extends JpaRepository<WorkflowStage,Integer>{
    List<WorkflowStage> findByCaseId(Integer caseId);
}
