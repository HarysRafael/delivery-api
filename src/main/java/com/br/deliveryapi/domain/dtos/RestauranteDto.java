package com.br.deliveryapi.domain.dtos;

import java.math.BigDecimal;

import com.br.deliveryapi.domain.model.Cozinha;
import com.br.deliveryapi.domain.model.FormaDePagamento;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RestauranteDto {

    private Long id;
    private String nome;
    private BigDecimal taxaFrete;
    private Cozinha cozinha;
    private FormaDePagamento formaDePagamento;

}
