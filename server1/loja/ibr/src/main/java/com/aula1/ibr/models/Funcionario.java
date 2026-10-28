package com.aula1.ibr.models;

import jakarta.persistence.*;

@Entity 
@Table(name="Funcionario")
public class Funcionario extends Pessoa {

    @Column (nullable = false)
    private double salario;
    protected Funcionario (){}

    public Funcionario(String nome,int idade,char sexo,double salario){
        super(nome,idade,sexo);
        this.salario=salario;
    }
    public double getSalario(){
        return salario;
    }

}
