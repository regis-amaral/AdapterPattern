package com.examples;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import com.examples.interfaces.ICotacaoXML;

import resources.CotadorXML;

/**
 * Classe para consulta de cotações de moedas com retorno em XML
 * 
 * Pares de moedas disponíveis:
 * https://economia.awesomeapi.com.br/xml/available
 * 
 */
public class CotacaoXML implements ICotacaoXML {

    private CotadorXML cotador;

    public CotacaoXML(){
        cotador = new CotadorXML();
    }

    /**
     * Retorna a cotação do par de moedas
     */
    @Override
    public String getCotacao(String moedas) {
        String xmlCotacao = cotador.getCambioXML(moedas);

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
