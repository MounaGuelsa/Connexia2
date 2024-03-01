package com.example.interaction.repository;

import com.example.interaction.dto.InteractionDto;
import com.example.interaction.entity.Interaction;
import jakarta.ws.rs.QueryParam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.List;
import java.util.Optional;
@EnableJpaRepositories
public interface InteractionRepository extends JpaRepository<Interaction, Long> {
    List<Interaction> findAllByIsdeletedFalse();
    @Query("select count(*) from Interaction where id_post=:id" )
    Integer NombreDesInteraction(@QueryParam("id") long id);
     @Query("select i from  Interaction i where i.id_compte=:Id_compte and i.id_post=:Id_post")
    Optional<InteractionDto> findByPostEtUser(@QueryParam("Id_compte") long Id_compte, @QueryParam("Id_post") long Id_post);

    @Query("select i from  Interaction i where i.id_post=:id")
    List<Interaction> findAllByPost(@QueryParam("id") long id);
}