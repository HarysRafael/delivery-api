package com.br.deliveryapi.domain.repository;

import java.util.Optional;

import com.br.deliveryapi.domain.model.Estado;
import com.br.deliveryapi.domain.model.enums.SiglasEstados;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstadoRepository extends JpaRepository<Estado, Long>{
    Optional<Estado> findBySiglasEstados(SiglasEstados SiglasEstados);
    Optional<Estado> findById(Long id);
	
}
