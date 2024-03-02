package com.example.commentaire.Client;
import com.example.notification.dto.NotificationDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "notification",path = "http://localhost:8088/notifications")
public interface NotificatonClient {
    @PostMapping("/save")
    ResponseEntity<NotificationDto> saveNotification(@RequestBody NotificationDto notificationDto);
}
