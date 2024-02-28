package com.yassin.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.ElementCollection;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import com.yassin.model.ImagePost;

import java.time.LocalDateTime;
import java.util.List;


/**
 * DTO for {@link ImagePost}
 */

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ImagePostDto {

    @NotNull
    private Long id;

    @NotNull
    private Long userId;

    @NotBlank
    private String title;

    @NotBlank
    private String description;

    @PastOrPresent
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime publishDate;

    @Min(0)
    private int reactions;

    @ElementCollection
    private List<Long> idComments;

    @NotBlank
    private String imageUrl;

    @NotNull
    private boolean deleted = false;

    @NotNull
    private boolean shared = false;

}
