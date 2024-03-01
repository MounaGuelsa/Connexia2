package com.example.notification.controller;

import com.example.notification.dto.NotificationDto;
import com.example.notification.service.INotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/notifications")
public class NotificationController {
    private final INotificationService iNotificationService;
    @Autowired
    public NotificationController(INotificationService iNotificationService) {
        this.iNotificationService = iNotificationService;
    }
    @PostMapping("/save")
    public ResponseEntity<NotificationDto> saveNotification(@RequestBody NotificationDto notificationDto){
        NotificationDto savedNotificationDto = iNotificationService.saveNotification(notificationDto);
        return new ResponseEntity<>(savedNotificationDto, HttpStatus.CREATED);

    }
    @DeleteMapping("/{id}")
    public  ResponseEntity<String>deleteNotification(@PathVariable Long id){
        iNotificationService.deleteNotification(id);
        return new ResponseEntity<>("Notification supprimée avec succès",HttpStatus.NO_CONTENT);

    }
}
