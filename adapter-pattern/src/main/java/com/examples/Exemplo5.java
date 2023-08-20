package com.examples;

import com.examples.adapters.CotacaoAdapterJSON;
import com.examples.adapters.CotacaoAdapterXML;
import com.examples.infrastructure.CotadorJSON;
import com.examples.infrastructure.CotadorXML;
import com.examples.interfaces.ICotacao;

public class Exemplo5 {
    public static void main(String[] args) {

        // Interface genérica com os métodos necessários para a aplicação
        ICotacao cotacao;

        String moedas = "USD-BRL";

        /**
         * Neste ponto vou utilizar o recurso que retorna dados em JSON (CotadorJSON),
         * injetando o recurso no CotacaoAdapterJSON
         */
        cotacao = new CotacaoAdapterJSON(new CotadorJSON());
        System.out.println("(API JSON) O câmbio " + moedas + " é de " + cotacao.getCotacao(moedas));
        /**
         * Aqui quero utilizar o recurso que retorna dados em XML
         * Logo, vou instanciar o adaptador XML e injetar nele o recurso que retorna os dados em XML
         */
        cotacao = new CotacaoAdapterXML(new CotadorXML());
        System.out.println("(API XML) O câmbio " + moedas + " é de " + cotacao.getCotacao(moedas));
    }
}
