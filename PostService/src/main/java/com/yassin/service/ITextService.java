package com.yassin.service;

import com.yassin.dto.TextPostDto;

import java.util.List;

public interface ITextService {

    TextPostDto createPost(TextPostDto textPostDto);

    TextPostDto updatePost(Long id, TextPostDto textPostDto);

    void deletePost(Long id);

    TextPostDto getPostById(Long id);

    List<TextPostDto> getAllPosts();

    List<TextPostDto> getAllPostsByUserId(Long userId);

    void validation(TextPostDto imagtextPostDto);
}
