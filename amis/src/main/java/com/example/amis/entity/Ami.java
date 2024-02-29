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
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private  Long id;
    private Long idRecepteur;
    private Long idEmetteur;
    private Boolean accepted;
    @Column(name = "is_deleted")

    private  Boolean deleted;
    private Boolean blocked;

}