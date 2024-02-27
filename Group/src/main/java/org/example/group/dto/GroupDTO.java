package org.example.group.dto;


import lombok.Data;

@Data
public class GroupDTO {
    private Long id;
    private String nom;
    private Long admin;
    private Boolean is_deleted;
    private String description;
}

