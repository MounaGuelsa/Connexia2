package com.example.commentaire.services;


import com.example.commentaire.dto.ComentaireDto;

import java.util.List;

public interface ComentaireService {
    default List<ComentaireDto> getAllComentaires(long id){
        return null;
    }
    default ComentaireDto getComentaireById(Long id){
        return null;
    }
    default ComentaireDto createComentaire(ComentaireDto comentaireDto){
        return comentaireDto;
    }
    default ComentaireDto updateComentaire(Long id, ComentaireDto comentaireDto){
        return comentaireDto;
    }
    default void deleteComentaire(Long id){}
}
