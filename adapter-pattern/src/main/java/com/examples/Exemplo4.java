package com.examples;

import com.examples.interfaces.ICotacaoJSON;
import com.examples.interfaces.ICotacaoXML;

public class Exemplo4 {
    public static void main(String[] args) {
        String moedas = "USD-BRL";
        String cotacaoRealDolar;

        /**
         *  Exemplo desacoplamento de código utilizando interface para obter os dados XML
         */
        
        ICotacaoXML cotacaoXML = new CotacaoXML();

        cotacaoRealDolar = cotacaoXML.getCotacao(moedas);

        System.out.println("(1) O câmbio " + moedas + " é de " + cotacaoRealDolar);

        /**
         * Agora vamos utilizar uma classe que adapta a interface ICotacaoXML 
         * para funcionar com a interface ICotacaoJSON
         */

        ICotacaoJSON cotacaoJSON = new CotacaoJSON();

        ICotacaoXML cotacaoXMLAdaptado = new CotacaoXMLAdapter(cotacaoJSON);

        cotacaoRealDolar = cotacaoXMLAdaptado.getCotacao(moedas);

        System.out.println("(2) O câmbio " + moedas + " é de " + cotacaoRealDolar);

    }
}
