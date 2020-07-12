package com.android.iam.botoomnavigation;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.android.iam.botoomnavigation.fragment.FeedFragment;
import com.android.iam.botoomnavigation.fragment.PerfilFragment;
import com.android.iam.botoomnavigation.fragment.PesquisaFragment;
import com.android.iam.botoomnavigation.fragment.PostagemFragment;
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        //configurar toobar

        //toolbar tem multiple opcao: android.support.v7.widget.Toolbar ou  android.widget.Toolbar
        android.support.v7.widget.Toolbar toolbar= findViewById(R.id.toolbarPrincipal);
        toolbar.setTitle("Instagram");
        setSupportActionBar(toolbar);




        //configuracao do bottom navigation view

        configuraBottomNavigationView();
//carrega inicialmente o FeedFragment
        android.support.v4.app.FragmentManager fragmentManager=fragmentManager=getSupportFragmentManager();
        android.support.v4.app.FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.viewPager,new FeedFragment()).commit();


    }


    //metodo de conf do botton navigation


    private void configuraBottomNavigationView(){

        BottomNavigationViewEx bottomNavigationViewEx=findViewById(R.id.bottomNavigation);

//conf iniciais
        bottomNavigationViewEx.enableAnimation(true);

        bottomNavigationViewEx.enableItemShiftingMode(false);
        bottomNavigationViewEx.setTextVisibility(false);
        bottomNavigationViewEx.enableShiftingMode(false);


        //habilitar a navegacao

        habilitarNavegacao(bottomNavigationViewEx);

//configura item selecionado incialmente
        Menu menu =bottomNavigationViewEx.getMenu();
        MenuItem menuItem=menu.getItem(0);
        menuItem.setChecked(true);

    }


    //trata eventos de click na bottomNavigation

    private void habilitarNavegacao(BottomNavigationViewEx viewEx){

        viewEx.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {


            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                //FragmentManager fragmentManager=getSupportFragmentManager();
                //FragmentManager fragmentManager=getSupportFragmentManager();

                android.support.v4.app.FragmentManager fragmentManager=fragmentManager=getSupportFragmentManager();
                android.support.v4.app.FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();





                switch(item.getItemId()){


                    case R.id.ic_home :
                        fragmentTransaction.replace(R.id.viewPager,new FeedFragment()).commit();
                        return  true;


                    case R.id.ic_pesquisa :
                        fragmentTransaction.replace(R.id.viewPager,new PesquisaFragment()).commit();
                        return  true;


                    case R.id.ic_perfil:
                        fragmentTransaction.replace(R.id.viewPager,new PerfilFragment()).commit();
                        return  true;



                    case R.id.ic_postagem :
                        fragmentTransaction.replace(R.id.viewPager,new PostagemFragment()).commit();
                        return  true;

                }


                return false;
            }
        });
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

            case R.id.menu_sair:
                deslogarUsuario();
               startActivity(new Intent(getApplicationContext(),Main2Activity.class));
                break;




        }








        return super.onOptionsItemSelected(item);
    }

    private void deslogarUsuario(){

        try {
            startActivity(new Intent(getApplicationContext(),Main2Activity.class));

        }catch(Exception e){


        }





    }






}
