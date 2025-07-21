package com.educational.alura.OraculoDoSaber.service;

import java.io.IOException;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsumoAPI {

    public final String ADRESS = "https://gutendex.com/books/?search=";

    public String obterDadosAPI(String busca) {

        String buscaEncodada2 = URLEncoder.encode(busca);

        String buscaEncodada = ADRESS + buscaEncodada2;

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(buscaEncodada)).build();

        HttpResponse<String> response = null;
        try {
            response = client.send(request,HttpResponse.BodyHandlers.ofString());
        } catch (IOException|InterruptedException e) {
            throw new RuntimeException(e);
        }

        String json = response.body();
        return json;
    }
}
