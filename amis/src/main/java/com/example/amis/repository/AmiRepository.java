package com.example.amis.repository;

import com.example.amis.dto.AmiDto;
import com.example.amis.entity.Ami;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AmiRepository extends JpaRepository<Ami,Long> {
    Optional<Ami> findAmiByIdEmetteur (Long idEmetteur);

}
