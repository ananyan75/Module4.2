package com.caseflow.caseflow.repository;
import com.caseflow.caseflow.entity.Cases;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
@Repository
public interface CasesRepository extends JpaRepository<Cases,Integer>{
    List<Cases> findByLitigantId(Integer litigantId);
    List<Cases> findByLawyerId(Integer lawyerId);
    List<Cases> findByStatus(String status);
}
