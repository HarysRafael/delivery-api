package com.br.deliveryapi.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;

import com.br.deliveryapi.domain.dtos.CozinhaDto;
import com.br.deliveryapi.domain.exception.EntidadeEmUsoException;
import com.br.deliveryapi.domain.exception.EntidadeNaoEncontradaException;
import com.br.deliveryapi.domain.model.Cozinha;
import com.br.deliveryapi.domain.repository.CozinhaRepository;

@Service
public class CadastroCozinhaService {

	@Autowired
	private CozinhaRepository cozinhaRepository;

	public CozinhaDto salvar(CozinhaDto cozinhaDto) {
		cozinhaRepository.findByNome(cozinhaDto.getNome()).ifPresent(cozinha1 ->{
			throw new EntidadeEmUsoException(
				"Cozinha de nome: " + cozinhaDto.getNome() + ", não pode ser adicionada, pois já está em uso.");
	});		
		Cozinha cozinha = converterDtoEmCozinha(cozinhaDto);
		cozinhaRepository.save(cozinha);
 		return converterCozinhaEmDto(cozinha);

	}

	public void excluir(Long cozinhaId) {
		try {
			cozinhaRepository.deleteById(cozinhaId);

		} catch (EmptyResultDataAccessException e) {
			throw new EntidadeNaoEncontradaException(
					String.format("Não existe um cadastro de cozinha com código %d", cozinhaId));

		} catch (DataIntegrityViolationException e) {
			throw new EntidadeEmUsoException(
					String.format("Cozinha de código %d não pode ser removida, pois está em uso", cozinhaId));
		}
	}

	public CozinhaDto editar(CozinhaDto cozinhaDto, Long id) {
		buscarPorId(id);
		cozinhaDto.setId(id);
		salvar(cozinhaDto);
		return cozinhaDto;
		
	}

	public List<CozinhaDto> listar() {
		return cozinhaRepository.findAll().stream().map(cozinha -> {
			return converterCozinhaEmDto(cozinha);
		}).collect(Collectors.toList());
	}

	public CozinhaDto buscarPorId(Long id) {
		Cozinha cozinha = cozinhaRepository.findById(id)
				.orElseThrow(() -> new EntidadeNaoEncontradaException(
					String.format("Não existe um cadastro de cozinha com código %d", id))
		);		
		return converterCozinhaEmDto(cozinha);
		
	}

	public Cozinha converterDtoEmCozinha(CozinhaDto cozinhaDto) {
		return Cozinha.builder().nome(cozinhaDto.getNome()).id(cozinhaDto.getId()).build();
	}

	public CozinhaDto converterCozinhaEmDto(Cozinha cozinha) {
		return CozinhaDto.builder().id(cozinha.getId()).nome(cozinha.getNome()).build();
	}

}
