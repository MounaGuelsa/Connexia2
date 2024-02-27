package com.yassin.repo;

import com.yassin.model.TextPost;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TextPostRepo extends JpaRepository<TextPost, Long> {
    List<TextPost> findByDeletedFalse();
    Optional<TextPost> findByIdAndDeletedFalse(Long id);
}
