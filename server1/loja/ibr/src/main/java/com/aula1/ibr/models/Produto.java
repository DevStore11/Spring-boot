package com.aula1.ibr.models;

import java.math.BigDecimal;

import org.hibernate.annotations.ColumnTransformer;

import jakarta.annotation.Generated;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.*;

@Entity 
@Table(name="produto")
public class Produto {
    @Id 
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false)
    private String nomeProduto;

    @Column(nullable = false)
    private int stock;

    @Column(nullable = false)
    private BigDecimal preco;

    protected Produto(){}

    public Produto(String nomeProduto,int stock,BigDecimal preco){
        this.nomeProduto=nomeProduto;
        this.stock=stock;
        this.preco=preco;
    }

    public Long getId(){
        return id;
    }
    public String getNomeProduto(){
        return nomeProduto;
    }
    public void setNomeProduto(String nomeProduto){
        this.nomeProduto=nomeProduto;
    }
    public int getStock(){
        return stock;
    }
    public void setStock(int stock){
        this.stock=stock;
    }
    public BigDecimal getPreco(){
        return preco;
    }
    public void setPreco(BigDecimal preco){
        this.preco=preco;
    }

    
}
