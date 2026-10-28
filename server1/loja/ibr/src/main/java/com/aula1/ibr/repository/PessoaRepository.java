package com.aula1.ibr.repository;
import com.aula1.ibr.models.*;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface PessoaRepository extends JpaRepository<Pessoa , Long> {
    
}
