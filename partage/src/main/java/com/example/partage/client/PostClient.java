//package com.example.partage.client;
//
//import com.yassin.dto.ImagePostDto;
//import com.yassin.dto.TextPostDto;
//import org.springframework.cloud.openfeign.FeignClient;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//
//@FeignClient(name = "post" , path = "http://localhost:8888/v1/api/image-posts")
//public interface PostClient {
//    @PostMapping("/create")
//     ResponseEntity<ImagePostDto> createPost(@RequestBody ImagePostDto imagePostDto);
//    @GetMapping("/{postId}")
//     ResponseEntity<ImagePostDto> getPostById(@PathVariable Long postId) ;
//
//}
