package com.example.notification.serviceTest;

import com.example.notification.dto.NotificationDto;
import com.example.notification.service.INotificationService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertNotNull;


@SpringBootTest
public class NotificationServiceTest {
    @Autowired
    private INotificationService iNotificationService;

    NotificationDto notificationDto;


    @BeforeEach
    void setUp(){
        notificationDto = new NotificationDto();
        notificationDto.setIdNotif(1L);
        notificationDto.setIdReceiver(2L);
        notificationDto.setMessage("Message de notification");
    }

    @Test
    void saveNotification() {
        NotificationDto notificationDto1 = iNotificationService.saveNotification(notificationDto);
        assertNotNull(notificationDto1,"Notif not found Not found");
    }


}
