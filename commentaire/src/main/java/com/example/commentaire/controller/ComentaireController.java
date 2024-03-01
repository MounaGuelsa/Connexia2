package com.example.commentaire.controller;


import com.example.commentaire.dto.ComentaireDto;
import com.example.commentaire.services.ComentaireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/commentaires")
public class ComentaireController {

    private final ComentaireService comentaireService;

    @Autowired
    public ComentaireController(ComentaireService comentaireService) {
        this.comentaireService = comentaireService;
    }

    @GetMapping("allCommentByPost/{id}")
    public ResponseEntity<List<ComentaireDto>> getAllComentairesByPost(@PathVariable Long id) {
        List<ComentaireDto> commentaires = comentaireService.getAllComentairesByidPost(id);
        return new ResponseEntity<>(commentaires, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ComentaireDto> getComentaireById(@PathVariable Long id) {
        ComentaireDto commentaire = comentaireService.getComentaireById(id);
        if (commentaire != null) {
            return new ResponseEntity<>(commentaire, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<ComentaireDto> createComentaire(@RequestBody ComentaireDto comentaireDto) {
        ComentaireDto createdComentaire = comentaireService.createComentaire(comentaireDto);
        return new ResponseEntity<>(createdComentaire, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ComentaireDto> updateComentaire(@PathVariable Long id, @RequestBody ComentaireDto comentaireDto) {
        ComentaireDto updatedComentaire = comentaireService.updateComentaire(id, comentaireDto);
        return new ResponseEntity<>(updatedComentaire, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteComentaire(@PathVariable Long id) {
        comentaireService.deleteComentaire(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
