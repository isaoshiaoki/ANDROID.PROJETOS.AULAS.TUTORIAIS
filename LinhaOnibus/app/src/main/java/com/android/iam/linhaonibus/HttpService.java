package com.android.iam.linhaonibus;

import android.os.AsyncTask;

import com.google.gson.Gson;

import java.io.IOException;
import java.io.PrintStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

import com.android.iam.linhaonibus.PosicaoOnibusDTO;

/**
 * Created by matheus on 13/11/17.
 * http://blog.matheuscastiglioni.com.br/consumindo-web-service-no-android
 * https://github.com/mahenrique94/requisicao-http
 *
 *
 * desmistificandoandroid.blogspot.com.br/2015/05/como-consumir-webservice-rest-no.html
 */

public class HttpService extends AsyncTask<Void, Void, PosicaoOnibusDTO> {

    private final String posicaoOnibus;

    public HttpService(String posicaoOnibus) {
        this.posicaoOnibus = posicaoOnibus;
    }

    @Override
    protected PosicaoOnibusDTO doInBackground(Void... voids) {
        StringBuilder resposta = new StringBuilder();

        if (this.posicaoOnibus!= null && this.posicaoOnibus.length() == 8) {
            try {
                URL url = new URL("http://dadosabertos.rio.rj.gov.br/apiTransporte/apresentacao/rest/index.cfm/onibus");



                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("GET");
                connection.setRequestProperty("Content-type", "application/json");
                connection.setRequestProperty("Accept", "application/json");
                connection.setDoOutput(true);
                connection.setConnectTimeout(5000);
                connection.connect();

                Scanner scanner = new Scanner(url.openStream());
                while (scanner.hasNext()) {
                    resposta.append(scanner.next());
                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return new Gson().fromJson(resposta.toString(), PosicaoOnibusDTO.class);
    }
}
