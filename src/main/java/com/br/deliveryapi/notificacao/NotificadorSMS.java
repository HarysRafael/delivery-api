package com.br.deliveryapi.notificacao;

import com.br.deliveryapi.modelo.Cliente;


import org.springframework.stereotype.Component;

@TipoDoNotificador(NivelUrgencia.URGENTE)
@Component
public class NotificadorSMS implements Notificador{ 

    @Override
    public void notificar(Cliente cliente, String mensagem){        
        System.out.printf("Notificando %s através de SMS pelo tenefone %s: %s \n", 
                cliente.getNome(), cliente.getTelefone(), mensagem);
    }

}
