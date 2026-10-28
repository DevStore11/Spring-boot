package com.aula.ibr.models;
import jakarta.persistence.*;
import java.time.LocalDateTime; 
import java.math.BigDecimal;

@Entity
@Table(name = "relatorio")
public class Relatorio {
     private String periodo;
    private double taxaOcupacao;
    private BigDecimal receitaTotal;
    
}
