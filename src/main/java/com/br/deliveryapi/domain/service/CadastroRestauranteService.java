package com.br.deliveryapi.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.br.deliveryapi.domain.dtos.RestauranteDto;
import com.br.deliveryapi.domain.exception.EntidadeEmUsoException;
import com.br.deliveryapi.domain.exception.EntidadeNaoEncontradaException;
import com.br.deliveryapi.domain.model.Cozinha;
import com.br.deliveryapi.domain.model.Restaurante;
import com.br.deliveryapi.domain.repository.CozinhaRepository;
import com.br.deliveryapi.domain.repository.RestauranteRepository;

@Service
public class CadastroRestauranteService {

	@Autowired
	private RestauranteRepository restauranteRepository;

	@Autowired
	private CozinhaRepository cozinhaRepository;

	public RestauranteDto salvar(RestauranteDto restauranteDto) {
		Long cozinhaId = restauranteDto.getCozinha().getId();
		Optional<Cozinha> cozinha = cozinhaRepository.findById(cozinhaId);
		if (cozinha.isEmpty()) {
			throw new EntidadeNaoEncontradaException(
					String.format("Não existe cadastro de cozinha com código %d", cozinhaId));
		}
		restauranteDto.setCozinha(cozinha.get());
		Restaurante restaurante = restauranteRepository.save(converterDtoEmRestaurante(restauranteDto));
		return converterRestauranteEmDto(restaurante);

	}

	public void excluir(Long restauranteId) {
		try {
			restauranteRepository.deleteById(restauranteId);
			
		} catch (EmptyResultDataAccessException e) {
			throw new EntidadeNaoEncontradaException(
				String.format("Não existe um cadastro de restaurante com código %d", restauranteId));
		
		} catch (DataIntegrityViolationException e) {
			throw new EntidadeEmUsoException(
				String.format("Restaurante de código %d não pode ser removido, pois está em uso", restauranteId));
		}
	}

	public RestauranteDto editar(Long id, RestauranteDto restauranteDto){
		buscarPorId(id);
		restauranteDto.setId(id);
		salvar(restauranteDto);
		return restauranteDto;
	}

	public RestauranteDto buscarPorId(Long id){
		Restaurante restaurante = restauranteRepository.findById(id)
				.orElseThrow(() -> new EntidadeNaoEncontradaException(
					String.format("Não existe um cadastro de cidade com código %d", id))
		);		
		return converterRestauranteEmDto(restaurante);
		
	}

	public List<RestauranteDto> listar() {
		return restauranteRepository.findAll().stream().map(restaurante -> {
			return converterRestauranteEmDto(restaurante);
		}).collect(Collectors.toList());
	}

	public Restaurante converterDtoEmRestaurante(RestauranteDto restauranteDto) {
		return Restaurante.builder().id(restauranteDto.getId()).formaDePagamento(restauranteDto.getFormaDePagamento())
				.taxaFrete(restauranteDto.getTaxaFrete()).nome(restauranteDto.getNome()).build();
	}

	public RestauranteDto converterRestauranteEmDto(Restaurante restaurante) {
		return RestauranteDto.builder().id(restaurante.getId()).formaDePagamento(restaurante.getFormaDePagamento())
				.taxaFrete(restaurante.getTaxaFrete()).nome(restaurante.getNome()).build();
	}

}
