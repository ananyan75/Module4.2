package com.caseflow.caseflow.repository;
import com.caseflow.caseflow.entity.Hearing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
@Repository
public interface HearingRepository extends JpaRepository<Hearing,Integer>{
List<Hearing> findByCaseId(Integer caseId);
List<Hearing> findByJudgeId(Integer judgeId);
}
