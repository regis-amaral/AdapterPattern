package com.examples.infrastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import com.examples.interfaces.ICotador;

public class CotadorJSON implements ICotador{
    
    public CotadorJSON(){
        
    }

    @Override
    public String getCambio(String moedas){
        try {
            URL url = new URL("https://economia.awesomeapi.com.br/json/" + moedas);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String inputLine;
                StringBuilder response = new StringBuilder();

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();

                String jsonResponse = response.toString();
                
                return jsonResponse;

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
            return null;
    }

}
