package com.br.deliveryapi.domain.controller;

import com.br.deliveryapi.domain.dtos.CidadeDto;
import com.br.deliveryapi.domain.service.CadastroCidadeService;

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

import java.util.List;

@RestController
@RequestMapping("/cidade")
public class CidadeController {

    private final CadastroCidadeService cadastroCidadeService;

    @Autowired
    public CidadeController(CadastroCidadeService cadastroCidadeService) {
        this.cadastroCidadeService = cadastroCidadeService;

    }

    @GetMapping
    public List<CidadeDto> listaCidades() {
        return cadastroCidadeService.listar();

    }

    @GetMapping("/{id}")
    public ResponseEntity<CidadeDto> buscaPorID(@PathVariable Long id) {
        CidadeDto cidadeResponse = cadastroCidadeService.buscarPorId(id);
        return ResponseEntity.ok(cidadeResponse);

    }

    @PostMapping
    public ResponseEntity<CidadeDto> criar(@RequestBody CidadeDto cidadeDto) {
        CidadeDto cidadeResponse = cadastroCidadeService.salvar(cidadeDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(cidadeResponse);

    }

    @DeleteMapping("/{id}")
    public void remover(@PathVariable Long id) {
        cadastroCidadeService.excluir(id);

    }

    @PutMapping("/{id}")
    public ResponseEntity<CidadeDto> editar(@PathVariable Long id, @RequestBody CidadeDto cidadeDto){
        CidadeDto cidadeResponse = cadastroCidadeService.editar(id, cidadeDto);
        return ResponseEntity.ok(cidadeResponse);

    }

}
