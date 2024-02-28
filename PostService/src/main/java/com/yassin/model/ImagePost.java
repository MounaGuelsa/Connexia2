package com.yassin.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "image_post")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ImagePost extends Post {


    private String imageUrl;
    private String description;

}
