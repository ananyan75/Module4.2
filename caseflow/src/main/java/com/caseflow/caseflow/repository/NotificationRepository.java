package com.caseflow.caseflow.repository;
import com.caseflow.caseflow.entity.Notification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
@Repository
public interface NotificationRepository extends JpaRepository<Notification,Integer>{
    List<Notification> findByUserId(Integer userId);
    List<Notification> findByUserIdAndStatus( Integer userId,String status);
}
