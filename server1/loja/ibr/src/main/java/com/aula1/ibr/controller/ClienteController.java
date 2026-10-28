package com.aula1.ibr.controller;

import java.util.List;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.aula1.ibr.models.Cliente;
import com.aula1.ibr.repository.ClienteRepository;
import com.aula1.ibr.service.ClienteService;

@RestController 
@RequestMapping("/clientes")
public class ClienteController {
    
    private ClienteService service;

    public ClienteController(ClienteService service){
        this.service=service;
    }
    @PostMapping 
    public Cliente criar(@RequestBody Cliente cliente){
        return service.criar(cliente);
    }
    @GetMapping 
    public List<Cliente>listar(){
        return service.listar();
    }
    @GetMapping ("/{id}")
    public Cliente buscar(@PathVariable  Long id){
        return service.buscar(id);
    }

    @DeleteMapping("/{id}")
    public void apagar(@PathVariable Long id){
        service.apagar(id);
    }
   

}
