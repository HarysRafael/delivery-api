package com.br.deliveryapi.domain.repository;


import com.br.deliveryapi.domain.model.FormaDePagamento;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FormaDePagamentoRepository extends JpaRepository<FormaDePagamento, Long>{

    
}
