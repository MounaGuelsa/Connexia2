package org.example.groupuser.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "group-user")
public class GroupUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="group-id")
    private Long groupId;
    @Column(name="user-id")
    private Long userId;
    @Column(name="is_deleted")
    private Boolean deleted;
}
