package com.example.amis.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "amis")
public class Ami {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  Long id;
    private Long idRecepteur;
    private Long idEmetteur;
    private Boolean accepted;
    private  Boolean is_deleted;
    private Boolean blocked;

}