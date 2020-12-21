package com.br.deliveryapi.domain.controller;

import java.util.List;

import com.br.deliveryapi.domain.dtos.RestauranteDto;
import com.br.deliveryapi.domain.service.CadastroRestauranteService;

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
@RequestMapping("/restaurante")
public class RestauranteController {

    private final CadastroRestauranteService cadastroRestauranteService;

    @Autowired
    public RestauranteController(CadastroRestauranteService cadastroRestauranteService){
        this.cadastroRestauranteService = cadastroRestauranteService;

    }

    @GetMapping
    public List<RestauranteDto> listaRestaurante() {
        return cadastroRestauranteService.listar();
    }

    @GetMapping("/{id}")
    public ResponseEntity<RestauranteDto> buscarPorId(@PathVariable Long id) {
        RestauranteDto restauranteResponse = cadastroRestauranteService.buscarPorId(id);
        return ResponseEntity.ok(restauranteResponse);

    }

    @PostMapping
    public ResponseEntity<RestauranteDto> criar(@RequestBody RestauranteDto restauranteDto) {
        RestauranteDto restauranteResponse = cadastroRestauranteService.salvar(restauranteDto);        
        return ResponseEntity.status(HttpStatus.CREATED).body(restauranteResponse);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        cadastroRestauranteService.excluir(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RestauranteDto> editar(@PathVariable Long id, @RequestBody RestauranteDto restauranteDto) {
        RestauranteDto restauranteResponse = cadastroRestauranteService.editar(id, restauranteDto);
        return ResponseEntity.ok(restauranteResponse);
    }

}
