package com.aula.ibr.models;
import java.time.LocalDateTime;
import jakarta.persistence.*;

@Entity 
@Table(name="bilhete")
public class Bilhete {
    @Id 
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column(nullable=false,length=100,unique=true)
    private String codigoUnico;

    @Column(nullable=false,length=100)
    private String lugar;
    
    @Column(nullable=false)
    private LocalDateTime dataEmissao;
    
    @ManyToOne(optional=false)
    @JoinColumn(name="id_reserva")
    private Reserva reserva;
}
