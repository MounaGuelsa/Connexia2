package com.example.commentaire.repository;

import com.example.commentaire.entity.Comentaire;
import jakarta.ws.rs.QueryParam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ComentaireRepository extends JpaRepository<Comentaire, Long> {
   // List<Comentaire> findAllByIsdeletedFalse();
    @Query("select  c from Comentaire c where c.id_post=:id")
    List<Comentaire>findAllById_post(@QueryParam("id") long id );
}