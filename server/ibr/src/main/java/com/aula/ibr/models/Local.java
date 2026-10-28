package com.aula.ibr.models;
import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.*;

@Entity 
@Table (name="local")
public class Local implements Agendavel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    private String endereco;

    @Column(nullable = false)
    private Integer capacidade;

    @OneToMany(mappedBy = "local", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Disponibilidade> disponibilidades = new ArrayList<>();
}
