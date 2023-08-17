package com.examples;

import com.examples.interfaces.ICotacaoXML;


public class Exemplo2 {
    public static void main(String[] args) {

        /**
         *  Exemplo desacoplamento de código utilizando interface para obter os dados XML
         */

        String moedas = "USD-BRL";
        ICotacaoXML cotacaoXML = new CotacaoXML();
        String cotacaoRealDolar = cotacaoXML.getCotacao(moedas);
        System.out.println("O câmbio " + moedas + " é de " + cotacaoRealDolar);
    }
}
