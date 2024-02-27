package com.yassin.repo;

import com.yassin.model.TextPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface TextPostRepo extends JpaRepository<TextPost, Long> {
    Optional<TextPost> findByIdAndDeletedFalse(Long id);

    List<TextPost> findAllByUserIdAndDeletedFalse(Long userId);

    List<TextPost> findAllByDeletedFalse();
}
