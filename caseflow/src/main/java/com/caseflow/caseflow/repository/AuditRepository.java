package com.caseflow.caseflow.repository;
import com.caseflow.caseflow.entity.Audit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
@Repository
public interface AuditRepository extends JpaRepository<Audit,Integer>{
    List<Audit> findByAdminId(Integer adminId);
    List<Audit> findByStatus(String status);
}
