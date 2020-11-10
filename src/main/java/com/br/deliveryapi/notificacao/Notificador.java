package com.br.deliveryapi.notificacao;

import com.br.deliveryapi.modelo.Cliente;

import org.springframework.stereotype.Component;

@Component
public interface Notificador {

    public void notificar(Cliente cliente, String mensagem);
    
}
