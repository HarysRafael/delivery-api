package com.br.deliveryapi.domain.dtos;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import com.br.deliveryapi.domain.model.enums.SiglasEstados;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EstadoDto {

    private Long id;
    @Enumerated(value = EnumType.STRING)
    private SiglasEstados siglasEstados;

}