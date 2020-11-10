package com.br.deliveryapi;

import com.br.deliveryapi.modelo.Cliente;
import com.br.deliveryapi.notificacao.Notificador;
import com.br.deliveryapi.notificacao.NotificadorEmail;
import com.br.deliveryapi.service.AtivacaoClienteService;

public class Main {

 public static void main(String[] args) {
    Cliente joao = new Cliente("joao", "emailjoao","123432");
    Cliente maria = new Cliente("maria", "emailmaria", "32323432");        

    Notificador notificador = new NotificadorEmail();
    
    AtivacaoClienteService ativar = new AtivacaoClienteService(notificador);
    ativar.ativarCliente(joao);
    ativar.ativarCliente(maria);


 }
    
}
