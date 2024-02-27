package com.example.Mantouji.entties;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Comentaire {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "compte_id")
    private Compte compte ;
    @ManyToOne
    @JoinColumn(name = "element_id")
    private Post element ;
    private String content ;
    private Boolean isdeleted ;
}
