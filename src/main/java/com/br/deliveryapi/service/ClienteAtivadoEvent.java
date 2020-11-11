package com.br.deliveryapi.service;

import com.br.deliveryapi.modelo.Cliente;

import lombok.Data;

@Data
public class ClienteAtivadoEvent {

    private Cliente cliente;

    public ClienteAtivadoEvent(Cliente cliente){
        super();
        this.cliente = cliente;
    } 
    
    
}
