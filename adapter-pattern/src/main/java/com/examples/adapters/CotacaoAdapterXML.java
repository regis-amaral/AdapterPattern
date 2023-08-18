package com.examples.adapters;

import com.examples.interfaces.ICotador;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import com.examples.infrastructure.CotadorXML;
import com.examples.interfaces.ICotacao;

public class CotacaoAdapterXML implements ICotacao {

    private ICotador cotador;

    public CotacaoAdapterXML(CotadorXML cotador){
        this.cotador = cotador;
    }

    @Override
    public String getCotacao(String moedas) {
        String xmlCotacao = cotador.getCambio(moedas);

        try {

            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            InputStream inputStream = new ByteArrayInputStream(xmlCotacao.getBytes("UTF-8"));
            Document document = builder.parse(inputStream);

            Element root = document.getDocumentElement();
            NodeList itemList = root.getElementsByTagName("item");
            Element item = (Element) itemList.item(0);
            String precoVenda = item.getElementsByTagName("ask").item(0).getTextContent();

            return precoVenda;
            
        } catch (Exception e) {
            System.out.println("Não foi possível carregar os dados de câmbio");
        }
        return null;
    }
    
}
