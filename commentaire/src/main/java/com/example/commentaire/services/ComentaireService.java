package com.example.Mantouji.services;

import com.example.Mantouji.dtos.ComentaireDto;

import java.util.List;

public interface ComentaireService {
    default List<ComentaireDto> getAllComentaires(){
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
