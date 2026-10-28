package com.aula.ibr.models;

import jakarta.persistence.*;

@Entity
@Table(name="administrador")
@PrimaryKeyJoinColumn(name="id_utilizador")
public class Administrador extends Utilizador {

    protected Administrador(){}

    public Administrador(String nome,String email,String senha, String telefone){
        super(nome,email,senha,telefone);
    }

    @Override
    public void abrirPainel() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'abrirPainel'");
    }
    

}
