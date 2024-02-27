package com.example.notification.service;

import com.example.notification.config.AppMapperConfig;
import com.example.notification.dto.NotificationDto;
import com.example.notification.entity.Notification;
import com.example.notification.repository.NotificationRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NotificationServiceImp implements INotificationService{
    private NotificationRepository notificationRepository;
    private ModelMapper modelMapper;

    @Autowired
    public NotificationServiceImp(NotificationRepository notificationRepository, ModelMapper modelMapper) {
        this.notificationRepository = notificationRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public NotificationDto saveNotification(NotificationDto notificationDto) {

        Notification notification = modelMapper.map(notificationDto,Notification.class);
        Notification savedNotif = notificationRepository.save(notification);
        return modelMapper.map(savedNotif,NotificationDto.class);

    }

    @Override
    public void deleteNotification(Long id) {
        notificationRepository.deleteById(id);
    }
}
