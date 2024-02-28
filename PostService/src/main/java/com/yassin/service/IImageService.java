package com.yassin.service;

import com.yassin.dto.ImagePostDto;

import java.util.List;

public interface IImageService {
    ImagePostDto createPost(ImagePostDto imagePostDto);

    ImagePostDto updatePost(Long id, ImagePostDto imagePostDto);

    void deletePost(Long id);

    ImagePostDto getPostById(Long id);

    List<ImagePostDto> getAllPosts();

    List<ImagePostDto> getAllPostsByUserId(Long userId);

    void validation(ImagePostDto imagePostDto);

}
