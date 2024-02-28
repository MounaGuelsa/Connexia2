package com.yassin.clients;

import com.example.commentaire.dto.ComentaireDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(path = "http://localhost:8092")
public interface CommentsClient {
    @GetMapping("/comments/post/{postId}")
    List<ComentaireDto> getCommentsByPostId(@PathVariable Long postId);
}
