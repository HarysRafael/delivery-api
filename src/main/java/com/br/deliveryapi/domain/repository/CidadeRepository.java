package com.br.deliveryapi.domain.repository;

import com.br.deliveryapi.domain.model.Cidade;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CidadeRepository extends JpaRepository<Cidade, Long>{

    


}
