package com.yassin.service;

import com.yassin.dto.TextPostDto;

import java.util.List;

public interface ITextService {

    void createPost(TextPostDto textPostDto);
    void updatePost(Long id, TextPostDto textPostDto);
    void deletePost(Long id);
    TextPostDto getPostById(Long id);
    List<TextPostDto> getAllPosts();
    List<TextPostDto> getAllPostsByUserId(Long userId);
    void validation(TextPostDto imagtextPostDto);
}
