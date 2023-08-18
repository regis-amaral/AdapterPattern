package com.examples;

import com.examples.adapters.CotacaoXMLAdapter;
import com.examples.interfaces.ICotacaoJSON;
import com.examples.interfaces.ICotacaoXML;
import com.examples.services.CotacaoJSON;

public class Exemplo4 {
    public static void main(String[] args) {
        String moedas = "USD-BRL";
        String cotacaoRealDolar;

        ICotacaoJSON cotacaoJSON = new CotacaoJSON();

        ICotacaoXML cotacaoXMLAdaptado = new CotacaoXMLAdapter(cotacaoJSON);

        cotacaoRealDolar = cotacaoXMLAdaptado.getCotacao(moedas);

        System.out.println("O câmbio " + moedas + " é de " + cotacaoRealDolar);

    }
}
