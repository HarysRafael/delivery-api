package com.br.deliveryapi.domain.model.enums;

public enum PagamentoVia {

    CREDITO("CREDITO"), DEBITO("DEBITO"), DINHEIRO("DINHEIRO");

    private String pagamentoVia;

    PagamentoVia(String pagamentoVia){
        this.pagamentoVia = pagamentoVia;

    }

    public String getPagamentoVia(){
        return this.pagamentoVia;
    }


}
