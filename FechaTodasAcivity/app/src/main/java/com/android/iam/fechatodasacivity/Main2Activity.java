package com.android.iam.fechatodasacivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Main2Activity extends AppCompatActivity {
    public EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Button bt2=(Button) findViewById(R.id.bt2);
        Button bt3=(Button) findViewById(R.id.bt3);

       //encerra app
        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               /* Intent it=new Intent(Main2Activity.this,MainActivity.class);
                startActivity(it);*/

            //solucao 1
            /* Main2Activity.this.finish();
                setResult(100);*/



                //solucao 2
                Intent  intent = new Intent(Main2Activity.this, MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
/*// set the new task and clear flags
                if(Build.VERSION.SDK_INT >= 11) {
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                } else {
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
                }*/
                startActivity( intent);
                getParent().finish();






            }

        });


        editText=  findViewById(R.id.editText);

   /*     //envia mensagem
        bt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String message=editText.getText().toString();
                Intent intent=new Intent();
                intent.putExtra("MENSAGEM",message);
                setResult(RESULT_OK,intent);



                *//*Intent i = new Intent(Main2Activity.this, MainActivity.class);
// set the new task and clear flags
                i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(i);*//*



                //encerra activity
                Main2Activity.this.finish();


            }

        });

*/



    }
}
