package com.example.amis.dto;

import lombok.*;

@Data
@NoArgsConstructor
public class AmiDto {
    private  Long id;
    private Long idRecepteur;
    private Long idEmetteur;
    private Boolean accepted;
    private Boolean deleted;
    private Boolean blocked;
}
