package com.aula.ibr.models;
import jakarta.persistence.Entity;
import jakarta.persistence.*;

@Entity
@Table(name="utilizador")
@Inheritance(strategy=InheritanceType.JOINED)
public abstract class Utilizador {
    @Id 
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable=false,length=100)
    private String nome;

    @Column(nullable=false,length=100,unique=true)
    private String email;

    @Column (nullable=false,length=100)
    private String senha;

    @Column(nullable=false,length=20)
    private String telefone;

    protected Utilizador(){}

    public Utilizador(String nome,String email,String senha,String telefone){
        this.nome=nome;
        this.email=email;
        this.senha=senha;
        this.telefone=telefone;

    }

    public Integer getId(){
        return id;
    }
    public String getNome(){
        return nome;
    }
    public void setNome(String nome){
        this.nome=nome;
    }
    public String getEmail(){
        return email;
    }
    public void setEmail(String email){
        this.email=email;
    }
    public String getSenha(){
        return senha;
    }
    public void setSenha(String senha){
        this.senha=senha;
    }
    public String getTelefone(){
        return telefone;
    }
    public void setTelefone(String telefone){
        this.telefone=telefone;
    }

    public abstract void abrirPainel();

}
