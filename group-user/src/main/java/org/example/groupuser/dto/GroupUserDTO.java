package org.example.groupuser.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class GroupUserDTO {
    private Long id;
    @NotBlank(message="nom null")
    private Long groupId;
    @NotBlank(message="nom null")
    private Long userId;
    private Boolean deleted;
}
