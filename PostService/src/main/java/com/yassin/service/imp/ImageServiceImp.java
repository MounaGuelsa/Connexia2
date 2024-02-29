package com.yassin.service.imp;

import com.example.commentaire.dto.ComentaireDto;
import com.example.commentaire.services.ComentaireServiceImpl;
import com.yassin.dto.ImagePostDto;
import com.yassin.model.ImagePost;
import com.yassin.repo.ImagePostRepo;
import com.yassin.service.IImageService;
import io.micrometer.core.instrument.util.StringUtils;
import jakarta.validation.ValidationException;
import jakarta.ws.rs.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ImageServiceImp implements IImageService {

    private final ModelMapper modelMapper;
    private final ImagePostRepo imagePostRepo;
    private ComentaireServiceImpl commentService;


    @Override
    public ImagePostDto createPost(ImagePostDto imagePostDto) {
        validation(imagePostDto);
        ImagePost imageToSave = modelMapper.map(imagePostDto, ImagePost.class);
        ImagePost image = imagePostRepo.save(imageToSave);
        return modelMapper.map(image, ImagePostDto.class);
    }

    @Override
    public ImagePostDto updatePost(Long id, ImagePostDto imagePostDto) {
        validation(imagePostDto);

        ImagePost imagePostExist = imagePostRepo.findByIdAndDeletedFalse(id).orElseThrow(
                () -> new NotFoundException("Post not found with this id : " + id));

        imagePostExist.setTitle(imagePostDto.getTitle());
        imagePostExist.setDescription(imagePostDto.getDescription());
        imagePostExist.setImageUrl(imagePostDto.getImageUrl());
        imagePostExist.setUserId(imagePostDto.getUserId());

        ImagePost updatedImagePost = imagePostRepo.save(imagePostExist);
        return modelMapper.map(updatedImagePost, ImagePostDto.class);
    }

    @Override
    public void deletePost(Long id) {
        ImagePost imagePost = imagePostRepo.findByIdAndDeletedFalse(id).orElseThrow(
                () -> new NotFoundException("User not found with this id : " + id));
        imagePost.setDeleted(true);
        imagePostRepo.save(imagePost);
    }

    @Override
    public ImagePostDto getPostById(Long id) {
        ImagePost imagePost = imagePostRepo.findByIdAndDeletedFalse(id).orElseThrow(
                () -> new NotFoundException("Post not found with this id : " + id));
        return modelMapper.map(imagePost, ImagePostDto.class);
    }

    @Override
    public List<ImagePostDto> getAllPosts() {
        List<ImagePost> imagePosts = imagePostRepo.findAllByDeletedFalse();
        return imagePosts.stream()
                .map(imagePost -> modelMapper.map(imagePost, ImagePostDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<ImagePostDto> getAllPostsByUserId(Long userId) {
        List<ImagePost> imagePosts = imagePostRepo.findAllByUserIdAndDeletedFalse(userId);
        return imagePosts.stream()
                .map(imagePost -> modelMapper.map(imagePost, ImagePostDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public void validation(ImagePostDto imagePostDto) {
        if (imagePostDto == null) {
            throw new ValidationException("Post data is required.");
        }

        if (StringUtils.isBlank(imagePostDto.getTitle())) {
            throw new ValidationException("Title is required.");
        }

        if (StringUtils.isBlank(imagePostDto.getDescription())) {
            throw new ValidationException("Description is required.");
        }

        if (StringUtils.isBlank(imagePostDto.getImageUrl())) {
            throw new ValidationException("Image URL is required.");
        }

        if (imagePostDto.getUserId() == null) {
            throw new ValidationException("User ID is required.");
        }
    }

    public List<ComentaireDto> getCommentsForPost(Long postId) {
        return commentService.getAllComentaires(postId);
    }
}
