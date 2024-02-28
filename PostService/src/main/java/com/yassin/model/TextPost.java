package com.yassin.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "text_post")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TextPost extends Post {

    private String text;

}
