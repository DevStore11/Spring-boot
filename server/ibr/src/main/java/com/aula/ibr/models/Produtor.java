package com.aula.ibr.models;
import java.util.List;
import java.util.ArrayList;
import jakarta.persistence.*;

@Entity 
@Table(name="produtor")
@PrimaryKeyJoinColumn(name="id_utilizador")
public class Produtor extends Utilizador {

    @OneToMany(mappedBy="produtor")
    private List<Espetaculo> espetaculos = new ArrayList<>();

    protected Produtor(){}

    public Produtor(String nome,String email,String senha,String telefone){
        super(nome,email,senha,telefone);
    }

    @Override
    public void abrirPainel() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'abrirPainel'");
    }

    
}
