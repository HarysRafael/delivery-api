package com.br.deliveryapi.listener;

import com.br.deliveryapi.notificacao.NivelUrgencia;
import com.br.deliveryapi.notificacao.Notificador;
import com.br.deliveryapi.notificacao.TipoDoNotificador;
import com.br.deliveryapi.service.ClienteAtivadoEvent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class NotificaçãoService {

    @TipoDoNotificador(NivelUrgencia.URGENTE)
    @Autowired
    private Notificador notificador;

    @EventListener
    public void clienteAtivadoListener(ClienteAtivadoEvent event){
        notificador.notificar(event.getCliente(),  " Seu cadastro no sistema está ativo!");

    }
    
}
