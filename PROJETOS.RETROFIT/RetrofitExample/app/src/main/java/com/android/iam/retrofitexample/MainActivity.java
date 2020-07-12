package com.android.iam.retrofitexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

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
                final Call<Usuario> call = githubUser.getUsuario("ammenendez");
                call.enqueue(new Callback<Usuario>() {



                    @Override
                    public void onResponse(Call<Usuario> call, Response<Usuario> response) {
                        int code = response.code();
                        if (code == 200) {
                            Usuario usuario = response.body();
                            Toast.makeText(getBaseContext(), "Nome do usuário: " +
                                    usuario.name, Toast.LENGTH_LONG).show();
                        } else {
                            Toast.makeText(getBaseContext(), "Falha: " + String.valueOf(code),
                                    Toast.LENGTH_LONG).show();
                        }
                    }
                    @Override
                    public void onFailure(Call<Usuario> call, Throwable t) {
                        Toast.makeText(getBaseContext(), t.getMessage(),
                                Toast.LENGTH_LONG).show();
                    }
                });
            }
        });


    }//onCreate()






}
