package com.aula1.ibr.service;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import com.aula1.ibr.models.Produto;
import com.aula1.ibr.repository.ProdutoRepository;

@Service
public class ProdutoService {
    private final ProdutoRepository repo;

    public ProdutoService(ProdutoRepository repo){
        this.repo=repo;
    }
    public Produto criarProduto(Produto produto){
        return repo.save(produto);
    }
    public List<Produto>listarProduto(){
        return repo.findAll();
    
    }
    public Produto actualizarProduto(Long id,Produto produtoActualizado){
        Produto produto=repo.findById(id).orElseThrow(()->new RuntimeException("Produto nao encontrado com ID:"+id));
        produto.setNomeProduto(produtoActualizado.getNomeProduto());
        produto.setPreco(produtoActualizado.getPreco());

        return repo.save(produto);
    }

    public Produto buscarProduto(Long id){
        return repo.findById(id).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"Produto nao encontrado " +id));
    }
    public void apagarProduto(Long id){
        buscarProduto(id);
        repo.deleteById(id);


    }

    
}
