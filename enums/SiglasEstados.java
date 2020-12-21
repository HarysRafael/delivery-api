package com.br.deliveryapi.domain.model.enums;


public enum SiglasEstados {

AC("AC"), AL("AL"), AP("AP"), AM("AM"), BA("BA"), CE("CE"), DF("DF"), ES("ES"), GO("GO"), MA("MA"), MT("MT"), MS("MS"), MG("MG"), PA("PA"), PB("PB"), PR("PR"), PE("PE"), PI("PI"), RJ("RJ"), RN("RN"), RS("RS"), RO("RO"), 
RR("RR"), SC("SC"), SP("SP"), SE("SE"), TO("TO");

private final String siglas;

    SiglasEstados(String siglas){
        this.siglas = siglas;

    }

    public String getSiglas(){
        return this.siglas;
    }

}
