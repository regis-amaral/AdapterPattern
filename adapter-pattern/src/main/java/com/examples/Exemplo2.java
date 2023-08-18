package com.examples;

import com.examples.interfaces.ICotacaoXML;
import com.examples.services.CotacaoXML;


public class Exemplo2 {
    public static void main(String[] args) {

        /**
         * Exemplo de desacoplamento de código utilizando uma interface para obter os dados XML,
         * e sua implementação em uma classe de serviço.
         */

        String moedas = "USD-BRL";
        ICotacaoXML cotacaoXML = new CotacaoXML();
        String cotacaoRealDolar = cotacaoXML.getCotacao(moedas);
        System.out.println("O câmbio " + moedas + " é de " + cotacaoRealDolar);
    }
}
