package com.caseflow.caseflow.repository;
import com.caseflow.caseflow.entity.Appeal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
@Repository
public interface AppealRepository extends JpaRepository<Appeal,Integer>{
    List<Appeal> findByCaseId(Integer caseId);
    List<Appeal> findByStatus(String status);
}
