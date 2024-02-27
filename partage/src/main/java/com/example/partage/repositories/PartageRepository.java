package com.example.partage.repositories;

import com.example.partage.entities.Partage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PartageRepository extends JpaRepository<Partage, Long> {

    List<Partage> findAllByIdPartageur(Long id);
    List<Partage> findAllByIdPost(Long id);

}
