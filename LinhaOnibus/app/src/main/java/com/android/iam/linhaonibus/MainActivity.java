package com.android.iam.linhaonibus;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.concurrent.ExecutionException;

import com.android.iam.linhaonibus.PosicaoOnibusDTO;
import com.android.iam.linhaonibus.HttpService;
//http://blog.matheuscastiglioni.com.br/consumindo-web-service-no-android
public class MainActivity extends AppCompatActivity {
public PosicaoOnibusDTO pos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);





        final EditText cep = findViewById(R.id.etMain_cep);
        final TextView resposta = findViewById(R.id.etMain_resposta);

         Button btnBuscarCep = findViewById(R.id.btnMain_buscarCep);

         btnBuscarCep.setOnClickListener(new android.view.View.OnClickListener() {
    @Override
    public void onClick(android.view.View view) {


        resposta.setText(pos.getPosicaoOnibus().toString());

        /*try {


           *//* PosicaoOnibusDTO retorno = new HttpService(cep.getText().toString()).execute().get();
            resposta.setText(retorno.toString());*//*

 //PosicaoOnibusDTO retorno = new HttpService(pos.getPosicaoOnibus()).execute().get();
            resposta.setText(pos.getPosicaoOnibus().toString());


        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (java.util.concurrent.ExecutionException e) {
            e.printStackTrace();
        }*/
    }
});






    }
}




























