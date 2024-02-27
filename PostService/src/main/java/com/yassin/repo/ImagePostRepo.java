package com.yassin.repo;

import com.yassin.model.ImagePost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface ImagePostRepo extends JpaRepository<ImagePost, Long> {
    List<ImagePost> findByDeletedFalse();
    Optional<ImagePost> findByIdAndDeletedFalse(Long id);
}
