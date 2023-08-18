package com.examples;

import com.examples.adapters.CotacaoAdapterJSON;
import com.examples.adapters.CotacaoAdapterXML;
import com.examples.infrastructure.CotadorJSON;
import com.examples.infrastructure.CotadorXML;
import com.examples.interfaces.ICotacao;

public class Exemplo5 {
    public static void main(String[] args) {
        ICotacao cotacao;
        String moedas = "USD-BRL";
        String cotacaoRealDolar;
        /**
         * Neste ponto vou utilizar o recurso que retorna dados em JSON,
         * injetando o recurso no adaptador JSON
         */
        cotacao = new CotacaoAdapterJSON(new CotadorJSON());
        cotacaoRealDolar = cotacao.getCotacao(moedas);
        System.out.println("(JSON) O câmbio " + moedas + " é de " + cotacaoRealDolar);
        /**
         * Aqui quero utilizar o recurso que retorna dados em XML
         * Logo, vou instanciar o adaptador XML e injetar nele o recurso que retorna os dados em XML
         */
        cotacao = new CotacaoAdapterXML(new CotadorXML());
        cotacaoRealDolar = cotacao.getCotacao(moedas);
        System.out.println("(XML) O câmbio " + moedas + " é de " + cotacaoRealDolar);
    }
}
