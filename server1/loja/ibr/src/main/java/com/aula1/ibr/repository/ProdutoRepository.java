package com.aula1.ibr.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.aula1.ibr.models.*;

public interface ProdutoRepository extends JpaRepository<Produto ,Long> {
    
}
