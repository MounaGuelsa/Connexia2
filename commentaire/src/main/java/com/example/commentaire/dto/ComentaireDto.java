package com.example.commentaire.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


@Data
@NoArgsConstructor
public class ComentaireDto implements Serializable {
    @NotNull(message = "L'identifiant ne peut pas être nul")
    Long id;

    @NotNull(message = "L'identifiant du compte ne peut pas être nul")
    Long id_compte;

    @NotNull(message = "L'identifiant de l'élément ne peut pas être nul")
    Long id_post;
    @NotNull(message = "contenu ne peut pas être nul")
    private String content ;
}
