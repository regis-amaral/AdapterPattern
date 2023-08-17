package com.examples;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import resources.CotadorXML;

public class Example1 
{
    public static void main( String[] args ){
        
        /**
         *  Exemplo de código acoplado / sem abstração
         */
        
         String moedas = "USD-BRL";
         CotadorXML cotacao = new CotadorXML();
         String xmlCotacao = cotacao.getCambioXML(moedas);
         try {
 
             DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
             DocumentBuilder builder = factory.newDocumentBuilder();
             InputStream inputStream = new ByteArrayInputStream(xmlCotacao.getBytes("UTF-8"));
             Document document = builder.parse(inputStream);
 
             Element root = document.getDocumentElement();
             NodeList itemList = root.getElementsByTagName("item");
             Element item = (Element) itemList.item(0);
             String precoCompra = item.getElementsByTagName("ask").item(0).getTextContent();
 
             System.out.println("O câmbio " + moedas + " é de " + precoCompra);
             
         } catch (Exception e) {
             System.out.println("Não foi possível carregar os dados de câmbio");
         }
    }
}
