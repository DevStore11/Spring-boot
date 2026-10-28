package com.aula1.ibr.models;

import jakarta.persistence.Entity;

import java.time.LocalDateTime;

import jakarta.persistence.*;

@Entity 
@Table(name="venda")
public class Venda {
    @Id 
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private  Long id;

    @Column(nullable = false)
    private int quantidade;

    @Column (nullable = false)
    private LocalDateTime data;

    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "id_funcionario")
    private Funcionario funcionario;

    @ManyToOne 
    @JoinColumn(name="id_produto")
    private Produto produto;

    protected Venda (){}

    public Venda(int quantidae,LocalDateTime data,Cliente cliente,Funcionario funcionario,Produto produto){
        this.quantidade=quantidae;
        this.data=data;
        this.cliente=cliente;
        this.funcionario=funcionario;
        this.produto=produto;
    }

    public Long getId(){
        return id;
    }    
    public int getQuantidade(){
        return quantidade;
    }
    public LocalDateTime getData(){
        return data;
    }
    public Cliente getCliente(){
        return cliente;
    }
    public Funcionario getFuncionario(){
        return funcionario;
    }
    public Produto geProduto(){
        return produto;
    }
}
