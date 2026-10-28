package com.aula1.ibr.service;
import com.aula1.ibr.repository.PessoaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;
import com.aula1.ibr.models.Pessoa;


@Service
public class PessoaService{
    private final PessoaRepository repo;

    public PessoaService(PessoaRepository repo){
        this.repo=repo;
    }
public Pessoa criarPessoa(Pessoa  pessoa){
    return repo.save(pessoa);
}
public List<Pessoa>listarPessoa(){
    return repo.findAll();
}
public Pessoa buscarPessoa(Long id){
    return repo.findById(id).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"Pessoa nao encontrada" + id));

}


}