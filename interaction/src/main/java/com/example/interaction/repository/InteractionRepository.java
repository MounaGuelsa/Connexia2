package com.example.interaction.repository;

import com.example.interaction.entity.Interaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InteractionRepository extends JpaRepository<Interaction, Long> {
    List<Interaction> findAllByIsdeletedFalse();
}