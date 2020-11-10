package com.br.deliveryapi.modelo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cliente {

    private String nome;
    private String email;
    private String telefone;
    private Boolean ativo = false;
    
    public Cliente(String nome, String email, String telefone){
        super();

        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
    }

    public void ativar(){
        this.ativo = true;
    }
}
