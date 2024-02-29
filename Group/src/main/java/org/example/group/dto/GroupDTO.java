package org.example.group.dto;


import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class GroupDTO {
    private Long id;
    @NotBlank(message="nom null")
    private String nom;
    @NotBlank(message="nom null")
    private Long admin;
    private Boolean deleted;
    private String description;
}

