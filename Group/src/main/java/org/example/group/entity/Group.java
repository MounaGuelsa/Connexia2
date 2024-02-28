package org.example.group.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "groupes")
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private Long admin;
    private Boolean is_deleted;
    private String description;
}
