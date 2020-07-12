package com.android.iam.retrofitlista;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


//https://www.youtube.com/watch?v=8ifDscl6RxM&list=PL2QkKoTK1V5GlubxDKp2TvnRQhjtoPhfh&index=13
//https://www.dropbox.com/s/m0r7ns9ictu0rr8/10%20-%20Acessando%20web%20services%20com%20Retrofit.pdf?dl=0
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button sincrono = (Button) findViewById(R.id.btnSincrono);
        sincrono.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                GithubUserAPI githubUser = GithubUserAPI.retrofit.create(GithubUserAPI.class);
                final Call<List<Usuario>> call = githubUser.getSeguidores("ammenendez");
                call.enqueue(new Callback<List<Usuario>>() {
                    @Override
                    public void onResponse(Call<List<Usuario>> call,
                                           Response<List<Usuario>> response) {
                        List<Usuario> lista = response.body();
                        for (Usuario usuario : lista) {
                            Log.d("MainActivity", usuario.login);
                        }
                    }
                    @Override
                    public void onFailure(Call<List<Usuario>> call, Throwable t) {
                    }




                });
            }
        });






    }
}
