package com.android.iam.toolbar;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
public class MainActivity extends AppCompatActivity {
//https://inducesmile.com/android/android-toolbar-tutorial-with-material-design/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //configurar toobar

        //toolbar tem multiple opcao: android.support.v7.widget.Toolbar ou  android.widget.Toolbar

        android.support.v7.widget.Toolbar toolbar= findViewById(R.id.toolbarPrincipal);
        toolbar.setTitle("Instagram");
        setSupportActionBar(toolbar);

    }


    /*@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
*/
}
