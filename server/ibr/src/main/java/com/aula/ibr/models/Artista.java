package com.aula.ibr.models;
import java.util.ArrayList;
import jakarta.persistence.*;
import java.util.List;

@Entity 
@Table(name="artista")
public class Artista implements Agendavel {
    @Id 
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable=false,length=100)
    private String nome;

    @Column(nullable=false,length=25)
    private String contacto;

    @Column(nullable=false,length=50)
    private String email;

    @OneToMany(mappedBy = "artista", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Disponibilidade> disponibilidades = new ArrayList<>();

    
}
