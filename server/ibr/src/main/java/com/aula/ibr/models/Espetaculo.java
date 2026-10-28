package com.aula.ibr.models;
import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="espetaculo")
public class Espetaculo {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private  Integer id;

    @Column(nullable=false,length=120)
    private String titulo;

    @Column(nullable=false,length=150)
    private String descricao;

    @Column(nullable=false,length=100)
    private String categoria;

    @Column(nullable=false)
    private LocalDateTime dataHora;

    @Column(nullable=false)
    private Double precoBilhete;

    @Column(nullable=false)
    private Integer lotacao;

    @Column (length=50)
    private String estado;

  @ManyToOne(optional = false)
    @JoinColumn(name = "produtor_id")
    private Produtor produtor;

    @ManyToOne(optional = false)
    @JoinColumn(name = "local_id")
    private Local local;

    @ManyToMany
    @JoinTable(name = "espetaculo_artista",
               joinColumns = @JoinColumn(name = "espetaculo_id"),
               inverseJoinColumns = @JoinColumn(name = "artista_id"))
    private Set<Artista> artistas = new HashSet<>();


    
}
