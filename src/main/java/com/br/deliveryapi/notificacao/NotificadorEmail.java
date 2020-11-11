package com.br.deliveryapi.notificacao;

import com.br.deliveryapi.modelo.Cliente;

import org.springframework.stereotype.Component;

@TipoDoNotificador(NivelUrgencia.NAOURGENTE)
@Component
public class NotificadorEmail implements Notificador{ 

    @Override
    public void notificar(Cliente cliente, String mensagem){        
        System.out.printf("Notificando %s através do e-mail %s: %s \n", 
                cliente.getNome(), cliente.getEmail(), mensagem);
    }

}
