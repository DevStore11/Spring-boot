package com.aula1.ibr.service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.aula1.ibr.models.Cliente;
import com.aula1.ibr.repository.ClienteRepository;

@Service
public class ClienteService {
    private final ClienteRepository repo;

    public ClienteService(ClienteRepository repo){
        this.repo=repo;
    }
    public Cliente criar(Cliente cliente){
        if(cliente.getNome()==null || cliente.getNome().isBlank()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"O nome e obrigatorio");
        }
        return repo.save(cliente);
        
    }
    public List<Cliente>listar(){
        return repo.findAll();
    }
    public Cliente buscar(Long id){
        return repo.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,"Cliente nao encontrado")
    
    );
    }
    public void apagar(Long id){
        buscar(id);
        repo.deleteById(id);
    }
    
    
}
