package com.caseflow.caseflow.service;
import com.caseflow.caseflow.entity.Notification;
import com.caseflow.caseflow.repository.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;
@Service
public class NotificationService {
    @Autowired
    private NotificationRepository notificationRepository;
    public void send(Integer userId,Integer caseId,String message,String category){
        Notification n=new Notification();
        n.setUserId(userId);
        n.setCaseId(caseId);
        n.setMessage(message);
        n.setCategory(category);
        n.setStatus("unread");
        n.setCreatedDate(LocalDateTime.now());
        notificationRepository.save(n);
    }
public List<Notification> getByUser(Integer userId){
        return notificationRepository.findByUserId(userId);
}
public void markRead(Integer notificationId){
        Notification n=notificationRepository.findById(notificationId).orElseThrow(()->new RuntimeException("Notification not found"));
        n.setStatus("Read");
        notificationRepository.save(n);
}
}
