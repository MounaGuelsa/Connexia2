package com.yassin.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "image_post")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ImagePost extends Post {


    @NotBlank
    private String imageUrl;

    @NotNull
    private boolean isDeleted;

    @NotBlank
    private String description;

}
