package com.aula.ibr.models;

import java.time.LocalDateTime;
import jakarta.persistence.*;
import java.util.List;
import java.util.ArrayList;

@Entity 
@Table(name="espetaculo")
public class Reserva {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

    @Column (nullable=false)
    private LocalDateTime dataReserva;

    @Column(nullable=false)
    private Integer quantidade;

    @Column(nullable=false)
    private Double valorTotal;

    @Column(nullable=false,length=20)
    private String estado;

    private LocalDateTime prazoExpiracao;

    @ManyToOne(optional=false)
    @JoinColumn(name="id_cliente")
    private Cliente cliente;

    @ManyToOne(optional=false)
    @JoinColumn(name="id_espetaculo")
    private Espetaculo espetaculo;

    @OneToMany(mappedBy="reserva")
    private List<Pagamento> pagamentos=new ArrayList<>();

    @OneToMany(mappedBy="reserva",cascade=CascadeType.ALL,orphanRemoval=true)
    private List<Bilhete> bilhetes=new ArrayList<>();
}
