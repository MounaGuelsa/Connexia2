package com.yassin.controller;

import com.yassin.dto.TextPostDto;
import com.yassin.service.ITextService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1/api/text-posts")
@RequiredArgsConstructor
public class TextPostController {

    private final ITextService textService;


    @PostMapping("/create")
    public ResponseEntity<TextPostDto> createPost(@RequestBody TextPostDto textPostDto) {
        return new ResponseEntity<>(textService.createPost(textPostDto), HttpStatus.CREATED);
    }


}
