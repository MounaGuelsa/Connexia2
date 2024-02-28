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
    @Column(name="is_deleted")
    private Boolean deleted;
    private String description;
}
