package com.android.iam.consultacepretrofit.service;

import com.android.iam.consultacepretrofit.model.CEP;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by matheus on 13/11/17.
 */

public interface CEPService {


   /*{cep} é nesse trecho que vamos informar um parâmetro
   essa lacuna {cep}, é nela que deve entrar o CEP informado pelo usuário, mas como vamos
    substituir a lacuna por um valor:
    precisamos mapear a qual lacuna esse parâmetro pertence,
    realizamos esse mapeamento através do @Path seguido pelo nome da lacuna
Pronto, agora sim, o valor passado para o parâmetro CEP será preenchido na lacuna {cep},
 se nossa lacuna chamasse {nome}, então nosso @Path seria nome.



http://blog.matheuscastiglioni.com.br/consumindo-web-service-no-android-com-retrofit
    */

    @GET("cep/find/{cep}/json")
    Call<CEP> buscarCEP(@Path("cep") String cep);

}
