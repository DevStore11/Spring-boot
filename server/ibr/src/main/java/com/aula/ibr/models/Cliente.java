package com.aula.ibr.models;
import jakarta.persistence.*;


@Entity 
@Table(name="cliente")
@PrimaryKeyJoinColumn(name="id_utilizador")
public class Cliente extends Utilizador {
    protected Cliente(){}

    public Cliente(String nome,String email,String senha,String telefone){
        super(nome,email,senha,telefone);
    }

    @Override
    public void abrirPainel() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'abrirPainel'");
    }
    
    
}
