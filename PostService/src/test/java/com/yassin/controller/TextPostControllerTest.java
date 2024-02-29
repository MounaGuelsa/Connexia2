package com.yassin.controller;

import com.yassin.dto.TextPostDto;
import com.yassin.service.imp.TextServiceImp;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Collections;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
class TextPostControllerTest {

    @Mock
    private TextServiceImp textService;

    @InjectMocks
    private TextPostController textPostController;

    private MockMvc mockMvc;

    @Test
    void getAllPostByIdUser() throws Exception {
        when(textService.getAllPostsByUserId(anyLong())).thenReturn(Collections.emptyList());

        mockMvc = MockMvcBuilders.standaloneSetup(textPostController).build();
        mockMvc.perform(get("/v1/api/text-posts/1/getPosts")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

    }

    @Test
    void getPostById() throws Exception {
        when(textService.getPostById(anyLong())).thenReturn(new TextPostDto());

        mockMvc = MockMvcBuilders.standaloneSetup(textPostController).build();
        mockMvc.perform(get("/v1/api/text-posts/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void createPost() throws Exception {
        when(textService.createPost(any(TextPostDto.class))).thenReturn(new TextPostDto());

        mockMvc = MockMvcBuilders.standaloneSetup(textPostController).build();
        mockMvc.perform(post("/v1/api/text-posts/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{}"))
                .andExpect(status().isCreated());
    }

    @Test
    void getCommentsForPost() throws Exception {
        when(textService.getCommentsForPost(anyLong())).thenReturn(Collections.emptyList());

        mockMvc = MockMvcBuilders.standaloneSetup(textPostController).build();
        mockMvc.perform(get("/v1/api/text-posts/posts/1/comments")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void updatePost() throws Exception {
        when(textService.updatePost(anyLong(), any(TextPostDto.class))).thenReturn(new TextPostDto());

        mockMvc = MockMvcBuilders.standaloneSetup(textPostController).build();
        mockMvc.perform(put("/v1/api/text-posts/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{}"))
                .andExpect(status().isOk());
    }

    @Test
    void deletePost() throws Exception {
        mockMvc = MockMvcBuilders.standaloneSetup(textPostController).build();
        mockMvc.perform(delete("/v1/api/text-posts/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNoContent());
    }
}