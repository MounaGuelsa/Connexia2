package com.yassin.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(max = 50)
    private String title;

    @NotNull
    private Long userId;

    @PastOrPresent
    private LocalDateTime publishDate;

    @Min(0)
    private int reactions;

 /*   @ElementCollection
    private List<Long> idComments;*/

    @NotNull
    private boolean shared = false;

    @NotNull
    private boolean deleted = false;



}
