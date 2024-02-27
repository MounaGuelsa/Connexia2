package com.example.notification.service;

import com.example.notification.dto.NotificationDto;

public interface INotificationService {

    NotificationDto saveNotification (NotificationDto notificationDto) ;
    void deleteNotification(Long id) ;


}
