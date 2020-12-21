package com.br.deliveryapi.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import com.br.deliveryapi.domain.dtos.EstadoDto;
import com.br.deliveryapi.domain.exception.EntidadeEmUsoException;
import com.br.deliveryapi.domain.exception.EntidadeNaoEncontradaException;
import com.br.deliveryapi.domain.model.Estado;
import com.br.deliveryapi.domain.repository.EstadoRepository;

@Service
public class CadastroEstadoService {

	@Autowired
	private EstadoRepository estadoRepository;

	public EstadoDto salvar(EstadoDto estadoDto) {
		estadoRepository.findBySiglasEstados(estadoDto.getSiglasEstados()).ifPresent(estado1 -> {
			throw new EntidadeEmUsoException(
					"Estado de nome: "+estadoDto.getSiglasEstados()+", não pode ser adicionado, pois já está em uso.");
		});
		Estado estado = converterDtoEmEstado(estadoDto);
		estadoRepository.save(estado);
 		return converterEstadoEmDto(estado);
	}

	public void excluir(Long estadoId) {
		try {
			estadoRepository.deleteById(estadoId);

		} catch (EmptyResultDataAccessException e) {
			throw new EntidadeNaoEncontradaException(
					String.format("Não existe um cadastro de estado com código %d", estadoId));

		} catch (DataIntegrityViolationException e) {
			throw new EntidadeEmUsoException(
					String.format("Estado de código %d não pode ser removido, pois está em uso", estadoId));
		}
	}

	public EstadoDto buscarPorId(Long id) {
		Estado estado = estadoRepository.findById(id)
				.orElseThrow(() -> new EntidadeNaoEncontradaException("Estado não encontrado através do Id: "+ id));
		return converterEstadoEmDto(estado);

	}

	public List<EstadoDto> listar() {
		return estadoRepository.findAll().stream().map(estado -> {
			return converterEstadoEmDto(estado);
		}).collect(Collectors.toList());
	}

	public EstadoDto editar(EstadoDto estadoDto, Long id) {
		buscarPorId(id);
		estadoDto.setId(id);
		salvar(estadoDto);
		return estadoDto;
	
	}

	public Estado converterDtoEmEstado(EstadoDto estadoDto) {
		return Estado.builder().siglasEstados(estadoDto.getSiglasEstados()).id(estadoDto.getId()).build();
	}

	public EstadoDto converterEstadoEmDto(Estado estado) {
		return EstadoDto.builder().id(estado.getId()).siglasEstados(estado.getSiglasEstados()).build();
	}
}
