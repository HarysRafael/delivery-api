package com.br.deliveryapi.domain.dtos;

import com.br.deliveryapi.domain.model.Estado;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CidadeDto {

    private Long id;
    private String nome;
    private Estado estado;

    
}
