package com.br.deliveryapi.service;

import com.br.deliveryapi.modelo.Cliente;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;


@Component
public class AtivacaoClienteService {
   
    @Autowired
    private ApplicationEventPublisher eventPublisher;

    public void ativarCliente(Cliente cliente){
        cliente.ativar();
        eventPublisher.publishEvent(new ClienteAtivadoEvent(cliente));
    }

}
