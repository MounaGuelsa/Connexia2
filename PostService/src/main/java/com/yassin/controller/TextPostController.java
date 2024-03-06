package com.yassin.controller;

import com.example.commentaire.dto.ComentaireDto;
import com.yassin.dto.TextPostDto;
import com.yassin.service.ITextService;
import com.yassin.service.imp.TextServiceImp;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/api/text-posts")
@RequiredArgsConstructor
public class TextPostController {

    private final TextServiceImp textService;

    @GetMapping("/{userId}/getPosts")
    public ResponseEntity<List<TextPostDto>> getAllPostByIdUser(@PathVariable Long userId) {
        return new ResponseEntity<>(textService.getAllPostsByUserId(userId), HttpStatus.OK);
    }

    @GetMapping("/{postId}")
    public ResponseEntity<TextPostDto> getPostById(@PathVariable Long postId) {
        return new ResponseEntity<>(textService.getPostById(postId), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<TextPostDto> createPost(@RequestBody TextPostDto textPostDto) {
        return new ResponseEntity<>(textService.createPost(textPostDto), HttpStatus.CREATED);
    }

//    @GetMapping("/posts/{postId}/comments")
//    public List<ComentaireDto> getCommentsForPost(@PathVariable Long postId) {
//        return textService.getCommentsForPost(postId);
//    }

    @PutMapping("/{postId}")
    public ResponseEntity<TextPostDto> updatePost(@PathVariable Long postId, @RequestBody TextPostDto textPostDto) {
        return new ResponseEntity<>(textService.updatePost(postId, textPostDto), HttpStatus.OK);
    }

    @DeleteMapping("/{postId}")
    public ResponseEntity<Void> deletePost(@PathVariable Long postId) {
        textService.deletePost(postId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}
