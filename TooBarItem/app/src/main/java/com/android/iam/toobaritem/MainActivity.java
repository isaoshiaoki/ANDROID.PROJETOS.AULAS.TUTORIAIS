package com.android.iam.toobaritem;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;
import    android.support.v7.widget.Toolbar;

public class MainActivity extends AppCompatActivity {
    //https://inducesmile.com/android/android-toolbar-tutorial-with-material-design/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //configurar toobar

        //toolbar tem multiple opcao: android.support.v7.widget.Toolbar ou  android.widget.Toolbar

      Toolbar toolbar= findViewById(R.id.toolbarPrincipal);
        toolbar.setTitle("ToolBar");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_home_black_24dp);

    }





    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);

        return super.onCreateOptionsMenu(menu);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {



            //https://pt.stackoverflow.com/questions/124065/trabalhando-com-bot%C3%B5es-back-da-navigation-barnativo-do-smartphone-e-action-bar
           /* case android.R.id.home:
                startActivity(new Intent(this, InicioActivity.class));
                //finishAffinity();
                break;*/

           //botao voltar configurado no manifest



            case R.id.menu_sair:
                deslogarUsuario();
                startActivity(new Intent(getApplicationContext(),Main2Activity.class));
                break;
            //id do botao
            case R.id.pencil:
                Toast.makeText(this,
                        "pencil", Toast.LENGTH_LONG).show();
                break;
               //id do botao
            case R.id.salvar:
                Toast.makeText(this,
                        "SALVAR", Toast.LENGTH_LONG).show();
            break;

            //id do botao
            case R.id.deletar:
                Toast.makeText(this,
                        "DELETAR", Toast.LENGTH_LONG).show();
                break;
            //id do botao
            case R.id.share:
                Toast.makeText(this,
                        "SHARE", Toast.LENGTH_LONG).show();
                break;

        }

        return super.onOptionsItemSelected(item);
    }

    private void deslogarUsuario(){

        try {
            //autenticacao.signOut();

        }catch(Exception e){


        }


    }
}
