package com.examples.adapters;

import com.examples.interfaces.ICotador;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.examples.infrastructure.CotadorJSON;
import com.examples.interfaces.ICotacao;

public class CotacaoAdapterJSON implements ICotacao {

    private ICotador cotador;

    public CotacaoAdapterJSON(CotadorJSON cotador){
        this.cotador = cotador;
    }

    @Override
    public String getCotacao(String moedas) {
        String jsonCotacao = cotador.getCambio(moedas);

        JsonArray jsonArray = JsonParser.parseString(jsonCotacao).getAsJsonArray();
        JsonObject jsonObject = jsonArray.get(0).getAsJsonObject();

    
        String precoVenda = jsonObject.get("ask").getAsString();

        return precoVenda;
    }
    
}
