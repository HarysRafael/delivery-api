package com.br.deliveryapi.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.br.deliveryapi.domain.dtos.CidadeDto;
import com.br.deliveryapi.domain.exception.EntidadeEmUsoException;
import com.br.deliveryapi.domain.exception.EntidadeNaoEncontradaException;
import com.br.deliveryapi.domain.model.Cidade;
import com.br.deliveryapi.domain.model.Estado;
import com.br.deliveryapi.domain.repository.CidadeRepository;
import com.br.deliveryapi.domain.repository.EstadoRepository;

@Service
public class CadastroCidadeService {

	@Autowired
	private CidadeRepository cidadeRepository;
	
	@Autowired
	private EstadoRepository estadoRepository;
	
	public CidadeDto salvar(CidadeDto cidadeDto) {
		Long estadoId = cidadeDto.getEstado().getId();
		Optional<Estado> estado = estadoRepository.findById(estadoId);
		
		if (estado.isEmpty()) {
			throw new EntidadeNaoEncontradaException(
				String.format("Não existe cadastro de estado com código %d", estadoId));
		}
		
		cidadeDto.setEstado(estado.get());
		Cidade cidade = cidadeRepository.save(converterDtoEmCidade(cidadeDto));
		
		return converterCidadeEmDto(cidade);
	}
	
	public void excluir(Long cidadeId) {
		try {
			cidadeRepository.deleteById(cidadeId);
			
		} catch (EmptyResultDataAccessException e) {
			throw new EntidadeNaoEncontradaException(
				String.format("Não existe um cadastro de cidade com código %d", cidadeId));
		
		} catch (DataIntegrityViolationException e) {
			throw new EntidadeEmUsoException(
				String.format("Cidade de código %d não pode ser removida, pois está em uso", cidadeId));
		}
	}

	public CidadeDto editar(Long id, CidadeDto cidadeDto){
		buscarPorId(id);
		cidadeDto.setId(id);
		salvar(cidadeDto);
		return cidadeDto;
	}

	public CidadeDto buscarPorId(Long id){
		Cidade cidade = cidadeRepository.findById(id)
				.orElseThrow(() -> new EntidadeNaoEncontradaException(
					String.format("Não existe um cadastro de cidade com código %d", id))
		);		
		return converterCidadeEmDto(cidade);
		
	}

	public List<CidadeDto> listar() {
		return cidadeRepository.findAll().stream().map(cidade -> {
			return converterCidadeEmDto(cidade);
		}).collect(Collectors.toList());
	}

	public Cidade converterDtoEmCidade(CidadeDto cidadeDto) {
		return Cidade.builder().id(cidadeDto.getId()).nome(cidadeDto.getNome()).estado(cidadeDto.getEstado()).build();
	}

	public CidadeDto converterCidadeEmDto(Cidade cidade) {
		return CidadeDto.builder().id(cidade.getId()).nome(cidade.getNome()).estado(cidade.getEstado()).build();
	}
	
}
