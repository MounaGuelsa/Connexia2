package com.example.users.dtos;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class UserDto implements Serializable {
    Long id;
    String nom;
    String prenom;
    String adresse;
    String email;
}
