package com.caseflow.caseflow.repository;
import com.caseflow.caseflow.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
@Repository
public interface ReviewRepository extends JpaRepository<Review,Integer>{
    List<Review> findByCaseId(Integer caseId);
    List<Review> findByJudgeId(Integer judgeId);
}
