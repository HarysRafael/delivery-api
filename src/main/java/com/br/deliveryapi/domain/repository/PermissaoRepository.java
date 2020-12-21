package com.br.deliveryapi.domain.repository;

import com.br.deliveryapi.domain.model.Permissao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PermissaoRepository extends JpaRepository<Permissao, Long>{

}
