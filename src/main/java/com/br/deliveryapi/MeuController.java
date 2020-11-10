package com.br.deliveryapi;

import com.br.deliveryapi.modelo.Cliente;
import com.br.deliveryapi.service.AtivacaoClienteService;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MeuController {

    private AtivacaoClienteService ativacaoClienteService;

    public MeuController(AtivacaoClienteService ativacaoClienteService) {
        this.ativacaoClienteService = ativacaoClienteService;
    }

    @GetMapping("/hello")
    @ResponseBody
    public Cliente ativar(){
        Cliente joao = new Cliente("joao", "joao@email.com", "123434323434");
         
        ativacaoClienteService.ativarCliente(joao);

        return joao;
    }

}
