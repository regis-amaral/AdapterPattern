package com.examples.adapters;

import com.examples.interfaces.ICotacaoJSON;
import com.examples.interfaces.ICotacaoXML;

public class CotacaoXMLAdapter implements ICotacaoXML {

    ICotacaoJSON cotacaoJSON;
    
    // Construct Injection
    public CotacaoXMLAdapter(ICotacaoJSON cotacaoJSON){
        this.cotacaoJSON = cotacaoJSON;
    }

    @Override
    public String getCotacao(String moedas) {
        return cotacaoJSON.getCotacao(moedas);
    }
}
