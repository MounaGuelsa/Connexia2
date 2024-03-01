package com.example.commentaire.services;


import com.example.commentaire.dto.ComentaireDto;

import java.util.List;

public interface ComentaireService {
    List<ComentaireDto> getAllComentairesByidPost(long id);
    ComentaireDto getComentaireById(Long id);
    ComentaireDto createComentaire(ComentaireDto comentaireDto);
   ComentaireDto updateComentaire(Long id, ComentaireDto comentaireDto);
    void deleteComentaire(Long id);
}
