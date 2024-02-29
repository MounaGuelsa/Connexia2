package com.yassin.controller;

import com.yassin.dto.ImagePostDto;
import com.yassin.service.imp.ImageServiceImp;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@ExtendWith(MockitoExtension.class)
class ImagePostControllerTest {

    @Mock
    private ImageServiceImp imageService;

    @InjectMocks
    private ImagePostController imagePostController;

    private MockMvc mockMvc;

    @Test
    void createPost() throws Exception {
        when(imageService.createPost(any(ImagePostDto.class))).thenReturn(new ImagePostDto());

        mockMvc = MockMvcBuilders.standaloneSetup(imagePostController).build();
        mockMvc.perform(post("/v1/api/image-posts/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{}"))
                .andExpect(status().isCreated());
    }

    @Test
    void getAllPostByIdUser() throws Exception {
        when(imageService.getAllPostsByUserId(anyLong())).thenReturn(Collections.emptyList());

        mockMvc = MockMvcBuilders.standaloneSetup(imagePostController).build();
        mockMvc.perform(get("/v1/api/image-posts/1/getPosts")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void getPostById() throws Exception {
        when(imageService.getPostById(anyLong())).thenReturn(new ImagePostDto());

        mockMvc = MockMvcBuilders.standaloneSetup(imagePostController).build();
        mockMvc.perform(get("/v1/api/image-posts/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void getCommentsForPost() throws Exception {
        when(imageService.getCommentsForPost(anyLong())).thenReturn(Collections.emptyList());

        mockMvc = MockMvcBuilders.standaloneSetup(imagePostController).build();
        mockMvc.perform(get("/v1/api/image-posts/posts/1/comments")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void updatePost() throws Exception {
        when(imageService.updatePost(anyLong(), any(ImagePostDto.class))).thenReturn(new ImagePostDto());

        mockMvc = MockMvcBuilders.standaloneSetup(imagePostController).build();
        mockMvc.perform(put("/v1/api/image-posts/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{}"))
                .andExpect(status().isOk());
    }

    @Test
    void deletePost() throws Exception {
        mockMvc = MockMvcBuilders.standaloneSetup(imagePostController).build();
        mockMvc.perform(delete("/v1/api/image-posts/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNoContent());
    }
}