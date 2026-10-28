package com.aula1.ibr.models;
import jakarta.persistence.*;

@Entity
@Table(name="Cliente")
public class Cliente extends Pessoa {

    
    protected Cliente() {}

    public Cliente(String nome,int idade,char sexo){
        super(nome,idade,sexo);
    }
    
  
    
}
