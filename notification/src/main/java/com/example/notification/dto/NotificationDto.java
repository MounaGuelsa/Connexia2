package com.example.notification.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class NotificationDto {
    private Long idNotif;
    private Long idReceiver;
    private String message;
}
