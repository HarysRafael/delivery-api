package com.br.deliveryapi.service;

import com.br.deliveryapi.modelo.Cliente;
import com.br.deliveryapi.notificacao.Notificador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AtivacaoClienteService {

    @Autowired
    private Notificador notificador;

    public AtivacaoClienteService(Notificador notificador){
        this.notificador = notificador;
    }

    
    public void ativarCliente(Cliente cliente){
        cliente.ativar();

       notificador.notificar(cliente, "Cadastro realizado com sucesso!");

    }

}
