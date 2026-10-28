package com.aula.ibr.models;
import java.time.LocalDateTime;

import jakarta.persistence.*;

@Entity 
@Table(name="notificacao")
public class Notificacao {
    @Id 
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable=false,length=150)
    private String tipo;

    @Column(nullable=false,length=200)
    private String mensagem;

    @Column(nullable=false,length=20)
    private String estado;

    @Column(nullable=false)
    private LocalDateTime dataEnvio;

    @ManyToOne(optional = false)
    @JoinColumn(name = "espetaculo_id")
    private Espetaculo espetaculo;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "artista_id")
    private Artista artista;

    @PrePersist
    @PreUpdate
    private void validarDestinatario() {
        if ((cliente == null) == (artista == null)) {
            throw new IllegalStateException(
                "A notificação tem um só destinatário: cliente ou artista.");
        }
    }


}
