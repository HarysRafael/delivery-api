package com.br.deliveryapi.domain.repository;

import java.util.Optional;

import com.br.deliveryapi.domain.model.Cozinha;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CozinhaRepository extends JpaRepository<Cozinha, Long>{
     Optional<Cozinha> findByNome(String nome);

    
}
