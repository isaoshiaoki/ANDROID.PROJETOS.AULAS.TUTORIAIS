package com.android.iam.exemplosimplesretrofit;


import retrofit2.Call;
import retrofit2.http.GET;


public interface UsuarioService {


    //para o cep
    @GET("get/cfgFlcvvDm?indent=2")
    Call<Usuario> getUsuarios();



/*//para o github
@GET("/users/ammenendez/followers")
    Call<List<Usuario>> getUsuarios();*/








/*
    @GET("/get/{usuario}")
    Call<List<Usuario>> getUsuarios(@Path("usuario") String usuario);
*/

}
