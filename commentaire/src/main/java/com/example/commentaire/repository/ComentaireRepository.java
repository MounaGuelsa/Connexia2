package com.example.commentaire.repository;

import com.example.commentaire.entity.Comentaire;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ComentaireRepository extends JpaRepository<Comentaire, Long> {
    List<Comentaire> findAllByIsdeletedFalse();
    List<Comentaire> findAllById_post(long id );
}