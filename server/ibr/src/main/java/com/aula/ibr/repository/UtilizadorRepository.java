package com.aula.ibr.repository;
 
import com.aula.ibr.models.Utilizador;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;


public interface UtilizadorRepository extends JpaRepository<Utilizador , Long> {

    Optional<Utilizador>findByEmailIgnoreCase(String email);

    boolean existsByEmailIgnoreCase(String email);

    
}
