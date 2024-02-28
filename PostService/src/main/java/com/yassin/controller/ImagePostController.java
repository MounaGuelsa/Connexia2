package com.yassin.controller;

import com.yassin.dto.ImagePostDto;
import com.yassin.dto.TextPostDto;
import com.yassin.service.IImageService;
import com.yassin.service.ITextService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/api/image-posts")
@RequiredArgsConstructor
public class ImagePostController {

    private final IImageService imageService;


    @PostMapping("/create")
    public ResponseEntity<ImagePostDto> createPost(@RequestBody ImagePostDto imagePostDto) {
        return new ResponseEntity<>(imageService.createPost(imagePostDto), HttpStatus.CREATED);
    }

    @GetMapping("/{userId}/getPosts")
    public ResponseEntity<List<ImagePostDto>> getAllPostByIdUser(@PathVariable Long userId) {
        return new ResponseEntity<>(imageService.getAllPostsByUserId(userId), HttpStatus.OK);
    }

}
