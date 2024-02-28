package com.yassin.controller;

import com.yassin.dto.TextPostDto;
import com.yassin.service.ITextService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/api/text-posts")
@RequiredArgsConstructor
public class TextPostController {

    private final ITextService textService;

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


}
