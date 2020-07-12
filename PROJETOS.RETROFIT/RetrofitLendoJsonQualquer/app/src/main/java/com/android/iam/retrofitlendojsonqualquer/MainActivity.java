package com.android.iam.retrofitlendojsonqualquer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class MainActivity extends AppCompatActivity {



//private static final String BASE_URL="https://api.github.com/";
private static final String BASE_URL="https://viacep.com.br/ws/";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       Retrofit retrofit = new Retrofit.Builder()
               .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
               .build();


UsuarioService service=retrofit.create(UsuarioService.class);
         Call<Usuario> usuarios=service.getUsuarios();
usuarios.enqueue(new Callback<Usuario>() {
    @Override
    public void onResponse(Call<Usuario> call, Response<Usuario> response) {


        //dados do cep
        Log.i("USER", response.body().getLocalidade() + "--" + response.body().getCep()  );

if(response.isSuccessful()) {
    //List<Usuario> users = response.body();




   /* for (Usuario u : users) {


        //dados do cep
        Log.i("USER", u.getLocalidade() + "--" + u.getCep()  );




       *//* //dados do github
        Log.i("USER", u.getLogin() + "--" + u.getAvatar_url());*//*







        Log.i("USER",  "-----------------------------" );
}*/




}else{

    Log.i("USER", "-------- ERRO-------" );
    Toast.makeText(getApplicationContext(),"ERRO :"+response.code(),Toast.LENGTH_LONG).show();

}




    }

    @Override
    public void onFailure(Call<Usuario> call, Throwable t) {
        Toast.makeText(getApplicationContext(),"ERRO :"+t.getMessage(),Toast.LENGTH_LONG).show();
    }
});


    }
}
