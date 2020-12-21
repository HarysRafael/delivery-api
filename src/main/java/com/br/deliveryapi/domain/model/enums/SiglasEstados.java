package com.br.deliveryapi.domain.model.enums;

public enum SiglasEstados {
    AP, AC, AL, AM, BA, BH, CE, PE, PB, PA, RN, SE, TO, GO, MS, MT, RR, RO, SP, RJ, DF, ES, MG, RS, PR, SC, MA;

    private String siglasEstados;

    SiglasEstados(String siglasEstados){
        this.siglasEstados = siglasEstados;
    }

    public String getSiglasEstados(){
        return this.siglasEstados;
    }

    SiglasEstados(){
    }
    
    
}
