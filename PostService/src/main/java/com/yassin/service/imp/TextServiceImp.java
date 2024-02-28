package com.yassin.service.imp;

import com.yassin.dto.ImagePostDto;
import com.yassin.dto.TextPostDto;
import com.yassin.model.ImagePost;
import com.yassin.model.TextPost;
import com.yassin.repo.TextPostRepo;
import com.yassin.service.ITextService;
import jakarta.ws.rs.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TextServiceImp implements ITextService {

    private final ModelMapper modelMapper;
    private final TextPostRepo textPostRepo;

    @Override
    public TextPostDto createPost(TextPostDto textPostDto) {
        validation(textPostDto);
        TextPost textPostToSave = modelMapper.map(textPostDto, TextPost.class);
        TextPost textPost = textPostRepo.save(textPostToSave);
        return modelMapper.map(textPost, TextPostDto.class);
    }

    @Override
    public TextPostDto updatePost(Long id, TextPostDto textPostDto) {
        validation(textPostDto);

        TextPost textPostExist = textPostRepo.findByIdAndDeletedFalse(id).orElseThrow(
                () -> new NotFoundException("Post not found with this id : " + id));

        // in all posts the user id can't be updated
        textPostExist.setTitle(textPostDto.getTitle());
        textPostExist.setText(textPostDto.getText());
        TextPost updatedTextPost = textPostRepo.save(textPostExist);
        return modelMapper.map(updatedTextPost, TextPostDto.class);

    }

    @Override
    public void deletePost(Long id) {
        TextPost textPost = textPostRepo.findByIdAndDeletedFalse(id).orElseThrow(
                () -> new NotFoundException("User not found with this id : " + id));
        textPost.setDeleted(true);
        textPostRepo.save(textPost);
    }

    @Override
    public TextPostDto getPostById(Long id) {
        TextPost textPost = textPostRepo.findByIdAndDeletedFalse(id).orElseThrow(
                () -> new NotFoundException("Post not found with this id : " + id));
        return modelMapper.map(textPost, TextPostDto.class);
    }

    @Override
    public List<TextPostDto> getAllPosts() {
        List<TextPost> textPosts = textPostRepo.findAllByDeletedFalse();
        return textPosts.stream()
                .map(textPost -> modelMapper.map(textPost, TextPostDto.class))
                .collect(Collectors.toList());
    }


    @Override
    public List<TextPostDto> getAllPostsByUserId(Long userId) {
        List<TextPost> textPosts = textPostRepo.findAllByUserIdAndDeletedFalse(userId);
        return textPosts.stream()
                .map(textPost -> modelMapper.map(textPost, TextPostDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public void validation(TextPostDto imagtextPostDto) {
        if (imagtextPostDto == null) {
            throw new IllegalArgumentException("Post data is required.");
        }

        if (imagtextPostDto.getTitle() == null || imagtextPostDto.getTitle().trim().isEmpty()) {
            throw new IllegalArgumentException("Title is required.");
        }

        if (imagtextPostDto.getText() == null || imagtextPostDto.getText().trim().isEmpty()) {
            throw new IllegalArgumentException("Text content is required.");
        }

        if (imagtextPostDto.getUserId() == null) {
            throw new IllegalArgumentException("User ID is required.");
        }
    }
}
