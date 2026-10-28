package com.aula1.ibr.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.service.annotation.GetExchange;
import java.util.List;

import com.aula1.ibr.models.Produto;
import com.aula1.ibr.service.ProdutoService;

@RestController
@RequestMapping("/produto") 
public class ProdutoController {
    private ProdutoService service;

    public ProdutoController(ProdutoService service){
        this.service=service;
    }

    @PostMapping
    public Produto criarProduto(@RequestBody Produto produto){
        return service.criarProduto(produto);
    }
    @GetMapping 
    public List<Produto>listarProduto(){
        return service.listarProduto();
    }
    @GetMapping ("/{id}")
    public Produto buscaProduto(@PathVariable Long id){
        return service.buscarProduto(id);
    }
     @PutMapping ("/{id}")
    public Produto actualizarProduto(@PathVariable Long id,@RequestBody Produto produtoActualizado){
        return service.actualizarProduto(id, produtoActualizado);
    }

    @DeleteMapping("/{id}")
    public void apagarProduto(@PathVariable Long id){
            service.apagarProduto(id);

    }


}
