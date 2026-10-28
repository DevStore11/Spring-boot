package com.aula.ibr.models;
import java.time.LocalDateTime;
import jakarta.persistence.*;

@Entity 
@Table(name="pagamento")
public class Pagamento {
    @Id 
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable=false,precision=10,scale=2)
    private Double valor;

    @Column(nullable=false,length=25)
    private String estado;

    @Column(nullable=false)
    private LocalDateTime data;

    @ManyToOne(optional=false)
    @JoinColumn(name="id_reserva")
    private Reserva reserva;
    
}
