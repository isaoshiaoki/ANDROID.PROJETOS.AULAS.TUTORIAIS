package com.android.iam.retrofitlendojsonqualquer;


import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Path;



public interface UsuarioService {


    //para o cep
    @GET("12570000/json/")
    Call<Usuario> getUsuarios();



/*//para o github
@GET("/users/ammenendez/followers")
    Call<List<Usuario>> getUsuarios();*/








/*
    @GET("/get/{usuario}")
    Call<List<Usuario>> getUsuarios(@Path("usuario") String usuario);
*/

}
