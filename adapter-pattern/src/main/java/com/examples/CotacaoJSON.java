package com.examples;

import com.examples.interfaces.ICotacaoJSON;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import resources.CotadorJSON;

public class CotacaoJSON implements ICotacaoJSON {

    private CotadorJSON cotador;

    public CotacaoJSON(){
        cotador = new CotadorJSON();
    }

    /**
     * Retorna a cotação do par de moedas
     */
    @Override
    public String getCotacao(String moedas) {

        String jsonCotacao = cotador.getCotacaoJSON(moedas);

        JsonArray jsonArray = JsonParser.parseString(jsonCotacao).getAsJsonArray();
        JsonObject jsonObject = jsonArray.get(0).getAsJsonObject();

    
        String precoVenda = jsonObject.get("ask").getAsString();

        return precoVenda;
    }

}
