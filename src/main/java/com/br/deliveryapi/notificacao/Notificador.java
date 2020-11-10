package com.br.deliveryapi.notificacao;

import com.br.deliveryapi.modelo.Cliente;

public interface Notificador {

    public void notificar(Cliente cliente, String mensagem);
    
}
