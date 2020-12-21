package com.br.deliveryapi.domain.controller;

import com.br.deliveryapi.domain.dtos.CozinhaDto;
import com.br.deliveryapi.domain.service.CadastroCozinhaService;

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
@RequestMapping("/cozinha")
public class CozinhaController {

    private final CadastroCozinhaService cadastroCozinhaService;

    @Autowired
    public CozinhaController(CadastroCozinhaService cadastroCozinhaService) {
        this.cadastroCozinhaService = cadastroCozinhaService;

    }

    @GetMapping
    public List<CozinhaDto> listaCozinhas() {
        return cadastroCozinhaService.listar();

    }

    @GetMapping("/{id}")
    public ResponseEntity<CozinhaDto> buscaPorID(@PathVariable Long id) {
        CozinhaDto cozinhaResponse = cadastroCozinhaService.buscarPorId(id);
        return ResponseEntity.ok(cozinhaResponse);

    }

    @PostMapping
    public ResponseEntity<CozinhaDto> criar(@RequestBody CozinhaDto cozinhaDto) {
        CozinhaDto cozinhaResponse = cadastroCozinhaService.salvar(cozinhaDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(cozinhaResponse);

    }

    @DeleteMapping("/{id}")
    public void remover(@PathVariable Long id) {
        cadastroCozinhaService.excluir(id);

    }

    @PutMapping("/{id}")
    public ResponseEntity<CozinhaDto> editar(@PathVariable Long id, @RequestBody CozinhaDto cozinhaDto) {
        CozinhaDto cozinhaResponse = cadastroCozinhaService.editar(cozinhaDto, id);
        return ResponseEntity.ok(cozinhaResponse);

    }

}
