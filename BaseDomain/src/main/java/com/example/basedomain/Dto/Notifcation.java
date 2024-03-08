package com.example.basedomain.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Notifcation {
    private Long idNotif;
    private Long idReceiver;
    private String message;
}
