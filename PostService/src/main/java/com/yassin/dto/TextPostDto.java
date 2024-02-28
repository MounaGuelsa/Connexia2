package com.yassin.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import com.yassin.model.TextPost;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * DTO for {@link TextPost}
 */

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TextPostDto {

    @NotNull
    private Long id;

    @NotBlank
    private String title;

    @NotNull
    private Long userId;

    @PastOrPresent
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime publishDate;

    @Min(0)
    private int reactions;

    private List<Long> idComments;

    @NotBlank
    private String text;

    @NotNull
    boolean deleted = false;
}
