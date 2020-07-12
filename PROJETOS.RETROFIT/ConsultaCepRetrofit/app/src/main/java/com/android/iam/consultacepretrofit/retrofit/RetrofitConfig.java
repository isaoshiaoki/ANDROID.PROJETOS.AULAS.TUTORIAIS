package com.android.iam.consultacepretrofit.retrofit;

import com.android.iam.consultacepretrofit.service.CEPService;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

/**
 * Created by matheus on 13/11/17.
 * http://blog.matheuscastiglioni.com.br/consumindo-web-service-no-android-com-retrofit
 */

public class RetrofitConfig {

    private final Retrofit retrofit;

   /*
   http://blog.matheuscastiglioni.com.br/consumindo-web-service-no-android-com-retrofit
   Informar a URL base do web service
    Adicionar um conversor de String(nossa resposta é um JSON, porém, a mesma vem em formato de String)
    para CEP(que será nosso objeto responsável por representar o CEP).
    E finalmente criar um objeto que representa o Retrofit.
    Começando a configuração
    Precisamos de um objeto do Retrofit, mas como podemos criá-lo? Para começarmos a configurá-lo
    temos o seu Builder, bem comum para construções de objetos:*/


    public RetrofitConfig() {
        this.retrofit = new Retrofit.Builder()
                .baseUrl("http://ws.matheuscastiglioni.com.br/ws/")
                .addConverterFactory(JacksonConverterFactory.create())
                .build();
    }

    public CEPService getCEPService() {
        return this.retrofit.create(CEPService.class);
    }

}
