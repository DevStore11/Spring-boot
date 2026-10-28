package com.aula1.ibr.service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.aula1.ibr.models.Funcionario;
import com.aula1.ibr.repository.FuncionarioRepository;

@Service 
public class FuncionarioService {
    private final FuncionarioRepository repo;

    public FuncionarioService(FuncionarioRepository repo){
        this.repo=repo;
    }
    public Funcionario criaFuncionario(Funcionario funcionario){
        if(funcionario.getNome()==null || funcionario.getNome().isBlank()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"O nome e obrigatorio");
        }
        return repo.save(funcionario);
    }
    public List<Funcionario>listarFuncionario(){
        return repo.findAll();
        
    }
    public Funcionario buscarFuncionario(Long id){
        return repo.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,"Funcionario nao encontrado"));
    }

    public void apagarFuncionario(Long id){
        buscarFuncionario(id);
        repo.deleteById(id);
    }


}
