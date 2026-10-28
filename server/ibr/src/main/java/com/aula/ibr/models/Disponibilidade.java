package com.aula.ibr.models;
import jakarta.persistence.*;
import java.time.LocalDateTime;


@Entity 
@Table (name="disponibilidade")
public class Disponibilidade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime dataInicio;
    private LocalDateTime dataFim;
    private boolean disponivel;

    @ManyToOne
    @JoinColumn(name = "local_id")
    private Local local;

    @ManyToOne
    @JoinColumn(name = "artista_id")
    private Artista artista;

    @PrePersist
    @PreUpdate
    private void validarDono() {
        if ((local == null) == (artista == null)) {
            throw new IllegalStateException(
                "A disponibilidade tem um só dono: local ou artista.");
        }
    }
    
}
