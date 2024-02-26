package com.example.partage.dtos;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class PartageDto implements Serializable {
    Long id;
    long idPartageur;
    long idPost;
    String PostUrl;
}
