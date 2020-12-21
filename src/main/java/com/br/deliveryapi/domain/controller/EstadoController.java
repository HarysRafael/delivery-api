package com.br.deliveryapi.domain.controller;

import java.util.List;

import com.br.deliveryapi.domain.dtos.EstadoDto;
import com.br.deliveryapi.domain.service.CadastroEstadoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/estado")
public class EstadoController {

    private final CadastroEstadoService cadastroEstadoService;

    @Autowired
    public EstadoController(CadastroEstadoService cadastroEstadoService){
        this.cadastroEstadoService = cadastroEstadoService;

    }

    @GetMapping
    public List<EstadoDto> listaEstados() {
        return cadastroEstadoService.listar();
    }

    @GetMapping("/{id}")
    public ResponseEntity<EstadoDto> buscarPorId(@PathVariable Long id) {
        EstadoDto estadoResponse = cadastroEstadoService.buscarPorId(id);
        return ResponseEntity.ok(estadoResponse);

    }

    @PostMapping
    public ResponseEntity<EstadoDto> criar(@RequestBody EstadoDto estadoDto) {
        EstadoDto estadoResponse = cadastroEstadoService.salvar(estadoDto);        
        return ResponseEntity.status(HttpStatus.CREATED).body(estadoResponse);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        cadastroEstadoService.excluir(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EstadoDto> editar(@PathVariable Long id, @RequestBody EstadoDto estadoDto) {
        EstadoDto estadoResponse = cadastroEstadoService.editar(estadoDto, id);
        return ResponseEntity.ok(estadoResponse);
    }

}
