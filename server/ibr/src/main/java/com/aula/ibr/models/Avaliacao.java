package com.aula.ibr.models;
import java.time.LocalDateTime;
import jakarta.persistence.*;

@Entity
@Table(name="avaliacao")
public class Avaliacao {
    @Id 
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable=false)
    private Integer nota;

    @Column(nullable=false,length=200)
    private String comentario;

    @Column(nullable=false)
    private LocalDateTime data;
    
}
