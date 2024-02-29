package com.yassin.controller;

import com.example.commentaire.dto.ComentaireDto;
import com.yassin.dto.ImagePostDto;
import com.yassin.dto.TextPostDto;
import com.yassin.service.IImageService;
import com.yassin.service.ITextService;
import com.yassin.service.imp.ImageServiceImp;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/api/image-posts")
@RequiredArgsConstructor
public class ImagePostController {

    private final ImageServiceImp imageService;


    @PostMapping("/create")
    public ResponseEntity<ImagePostDto> createPost(@RequestBody ImagePostDto imagePostDto) {
        return new ResponseEntity<>(imageService.createPost(imagePostDto), HttpStatus.CREATED);
    }

    @GetMapping("/{userId}/getPosts")
    public ResponseEntity<List<ImagePostDto>> getAllPostByIdUser(@PathVariable Long userId) {
        return new ResponseEntity<>(imageService.getAllPostsByUserId(userId), HttpStatus.OK);
    }

    @GetMapping("/{postId}")
    public ResponseEntity<ImagePostDto> getPostById(@PathVariable Long postId) {
        return new ResponseEntity<>(imageService.getPostById(postId), HttpStatus.OK);
    }

    @GetMapping("/posts/{postId}/comments")
    public List<ComentaireDto> getCommentsForPost(@PathVariable Long postId) {
        return imageService.getCommentsForPost(postId);
    }

    @PutMapping("/{postId}")
    public ResponseEntity<ImagePostDto> updatePost(@PathVariable Long postId, @RequestBody ImagePostDto imagePostDto) {
        return new ResponseEntity<>(imageService.updatePost(postId, imagePostDto), HttpStatus.OK);
    }

    @DeleteMapping("/{postId}")
    public ResponseEntity<Void> deletePost(@PathVariable Long postId) {
        imageService.deletePost(postId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
