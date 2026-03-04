package com.caseflow.caseflow.controller;
import com.caseflow.caseflow.entity.Notification;
import com.caseflow.caseflow.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/notifications")
public class NotificationController {
    @Autowired
    private NotificationService notificationService;

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Notification>> getByUser(
            @PathVariable Integer userId){
        return ResponseEntity.ok(
                notificationService.getByUser(userId));
    }
    @PatchMapping("/{notificationId}/read")
    public ResponseEntity<Void> marksRead(
            @PathVariable Integer notificationId){
        notificationService.markRead(notificationId);
        return ResponseEntity.ok().build();
    }
}
