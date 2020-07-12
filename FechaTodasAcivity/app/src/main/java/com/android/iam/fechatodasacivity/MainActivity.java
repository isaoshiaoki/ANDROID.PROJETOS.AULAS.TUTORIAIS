package com.android.iam.fechatodasacivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        Button bt1=(Button) findViewById(R.id.bt1);
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it=new Intent(MainActivity.this,Main2Activity.class);
               startActivity(it);
                //startActivityForResult(it, 100);// Activity é iniciada com requestCode 1



            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


   /* // Recebe os dados da outra Activity
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);
        // Verfica se o requestCode é o mesmo que foi passado
        if(requestCode==100 && resultCode == RESULT_OK )

        {


            *//*Intent i = new Intent(MainActivity.this, Main2Activity.class);
// set the new task and clear flags
            i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(i);*//*



            String mensagem=data.getStringExtra("MENSAGEM");
            Toast.makeText(getApplicationContext() ,  " Mensagem :" + mensagem +"1", Toast.LENGTH_SHORT).show();


            MainActivity.this.finish();



        }
        *//*if(requestCode==100  )

        {

            Toast.makeText(getApplicationContext() ,  " requestCode == 100"  , Toast.LENGTH_SHORT).show();


            MainActivity.this.finish();

        }

        if(resultCode == RESULT_OK )

        {
            Toast.makeText(getApplicationContext() ,  " resultCode == RESULT_OK"  , Toast.LENGTH_SHORT).show();
            MainActivity.this.finish();
        }*//*



        *//*switch (requestCode) {
            case 100:
                this.finish();
                break;

            case RESULT_OK:
                String mensagem=data.getStringExtra("MENSAGEM");
                Toast.makeText(getApplicationContext() ,  " Mensagem :" + mensagem , Toast.LENGTH_SHORT).show();
                break;



        }*//*
        super.onActivityResult(requestCode, resultCode, data);
    }


*/







    }










