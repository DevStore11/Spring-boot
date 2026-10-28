package com.aula1.ibr.models;

import jakarta.persistence.*;

@Entity
@Table(name="Pessoa")
@Inheritance(strategy=InheritanceType.JOINED)
public abstract class Pessoa{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column(nullable=false,length=100)
    private String nome;

    @Column(nullable=false)
    private int idade;

    @Column(nullable=false)
    private char sexo;

   protected Pessoa() {}

   public Pessoa(String nome,int idade,char sexo){
    this.nome=nome;
    this.idade=idade;
    this.sexo=sexo;
   }

   public Long getId(){
    return id;
   }
   public String getNome(){
    return nome;
   }
   public void setNome(String nome){
    this.nome=nome;
   }
   public int getIdade(){
    return idade;
   }
   public void setIdade(int idade){
    this.idade=idade;
   }
   public char getSexo(){
    return sexo;
   }
   public void setSexo(char sexo){
    this.sexo=sexo;
   }
   




}