package com.examples;

import com.examples.interfaces.ICotacao;

public class CambioService {
    
    private ICotacao cotacao;

    public CambioService(ICotacao cotacao){
        this.cotacao = cotacao;
    }

    public void printCambio(String moedas) {
        String cotacaoRealDolar = this.cotacao.getCotacao(moedas);
        System.out.println("O câmbio " + moedas + " é de " + cotacaoRealDolar);
    }
}
