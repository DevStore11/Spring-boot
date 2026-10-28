package com.aula1.ibr.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aula1.ibr.models.Funcionario;
import com.aula1.ibr.service.FuncionarioService;

@RestController 
@RequestMapping("/funcionario")
public class FuncionarioController {
    private FuncionarioService service;

    public FuncionarioController(FuncionarioService service){
        this.service=service;
    }
    @PostMapping 
    public Funcionario criarFuncionario(@RequestBody Funcionario funcionario){
        return service.criaFuncionario(funcionario);
    }
    @GetMapping 
    public List<Funcionario>listaFuncionarios(){
        return service.listarFuncionario();
    }
    @GetMapping("/{id}") 
    public Funcionario buscarFuncionario(@PathVariable Long id){
        return service.buscarFuncionario(id);
    }
    @DeleteMapping("/{id}")
    public void apagarFuncionario(@PathVariable Long id){
        service.apagarFuncionario(id);
    }
    
}
