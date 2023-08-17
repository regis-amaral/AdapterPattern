package com.examples;

import com.examples.interfaces.ICotacaoJSON;
import com.examples.interfaces.ICotacaoXML;

public class CotacaoXMLAdapter implements ICotacaoXML {

    ICotacaoJSON cotacaoJSON;
    
    public CotacaoXMLAdapter(ICotacaoJSON cotacaoJSON){
        this.cotacaoJSON = cotacaoJSON;
    }

    @Override
    public String getCotacao(String moedas) {
        return cotacaoJSON.getCotacao(moedas);
    }
}
