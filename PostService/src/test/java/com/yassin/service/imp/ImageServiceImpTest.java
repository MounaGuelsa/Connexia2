package com.yassin.service.imp;

import com.yassin.dto.ImagePostDto;
import com.yassin.repo.ImagePostRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ImageServiceImpTest {

    @Autowired
    private ImageServiceImp imageService;

    /*@BeforeEach
    void setUp() {
        ImagePostRepo imagePostRepo = new ImagePostRepo();
        ModelMapper modelMapper = new ModelMapper();
        imageService = new ImageServiceImp(imagePostRepo, modelMapper);
    }*/


    @Test
    void createPost() {
      /*  ImagePostDto imagePostDto = new ImagePostDto();
        imagePostDto.setTitle("Test Title");
        imagePostDto.setDescription("Test Description");
        imagePostDto.setUserId(1L);

        // Call the method under test
        ImagePostDto result = imageService.createPost(imagePostDto);

        // Assert the result
        assertNotNull(result);
        assertEquals("Test Title", result.getTitle());
        assertEquals("Test Description", result.getDescription());
        assertNull(result.getImageUrl());
        assertEquals(1L, result.getUserId());
*/
    }

    @Test
    void updatePost() {
    }

    @Test
    void deletePost() {
    }

    @Test
    void getPostById() {
    }

    @Test
    void getAllPosts() {
    }

    @Test
    void getAllPostsByUserId() {
    }

    @Test
    void validation() {
    }

    @Test
    void getCommentsForPost() {
    }
}