package com.examples;

import com.examples.interfaces.ICotacaoJSON;
import com.examples.interfaces.ICotacaoXML;
import com.examples.services.CotacaoJSON;
import com.examples.services.CotacaoXML;

public class Exemplo3 {
    public static void main(String[] args) {
        String moedas = "USD-BRL";
        String cotacaoRealDolar;

        ICotacaoXML cotacaoXML = new CotacaoXML();
        cotacaoRealDolar = cotacaoXML.getCotacao(moedas);
        System.out.println("(1) O câmbio " + moedas + " é de " + cotacaoRealDolar);

        /**
         * Agora surge a necessidade de utilizar dados de uma nova biblioteca, mas
         * ela retorna dados no formato JSON
         */

        // Essa implementação abaixo não será aceita:
        ICotacaoJSON cotacaoJSON = new CotacaoJSON();
        cotacaoRealDolar = cotacaoJSON.getCotacao(moedas);
        System.out.println("(2) O câmbio " + moedas + " é de " + cotacaoRealDolar);

        // Problema: Como fazer com que a aplicação siga utilizando somente a interface ICotacaoXML?
    }
}
