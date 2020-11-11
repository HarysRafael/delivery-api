package com.br.deliveryapi.service;

import com.br.deliveryapi.modelo.Cliente;
import com.br.deliveryapi.notificacao.NivelUrgencia;
import com.br.deliveryapi.notificacao.Notificador;
import com.br.deliveryapi.notificacao.TipoDoNotificador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;


@Component
public class AtivacaoClienteService {

    @TipoDoNotificador(NivelUrgencia.NAOURGENTE)
    @Autowired
    private Notificador notificador;
    
    @Autowired
    private ApplicationEventPublisher eventPublisher;

    public void ativarCliente(Cliente cliente){
        cliente.ativar();
        eventPublisher.publishEvent(new ClienteAtivadoEvent(cliente));
    }

}
