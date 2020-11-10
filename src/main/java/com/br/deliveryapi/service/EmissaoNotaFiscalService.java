package com.br.deliveryapi.service;

import com.br.deliveryapi.modelo.Cliente;
import com.br.deliveryapi.modelo.Produto;
import com.br.deliveryapi.notificacao.Notificador;

public class EmissaoNotaFiscalService {

    private Notificador notificador;

    public EmissaoNotaFiscalService(Notificador notificador){
        this.notificador = notificador;
    }

    public void emitir(Cliente cliente, Produto produto){
        
        this.notificador.notificar(cliente, "Nota fiscal do produto "+ produto.getNome() + " foi emitida.");
    }
    
}
