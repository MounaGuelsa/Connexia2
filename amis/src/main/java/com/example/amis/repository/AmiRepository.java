package com.example.amis.repository;

import com.example.amis.entity.Ami;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AmiRepository extends JpaRepository<Ami,Long> {
}
