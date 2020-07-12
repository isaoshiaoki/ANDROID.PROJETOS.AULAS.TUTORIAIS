package com.android.iam.recuperaestadoantesderotacionar;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

public class MainActivity extends AppCompatActivity {
private ImageView img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView img=findViewById(R.id.imageView);

        img.setImageResource(R.drawable.monica);



    }

//metodos para recupera estado da activity antes de rotacionar
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
// exemplo de conversao de imagem para bytes e vice versa
        Bitmap bmp = BitmapFactory.decodeResource(getResources(),R.drawable.mickey);
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bmp.compress(Bitmap.CompressFormat.JPEG, 100, stream);
        byte[] imagemByteArray = stream.toByteArray();


//do onSaveInstanceState que coloca os bytes da imagem
        outState.putByteArray("imagemByteArray",imagemByteArray);

    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        byte[] bitmapByteArray=savedInstanceState.getByteArray("imagemByteArray");


        ByteArrayInputStream arrayInputStream = new ByteArrayInputStream(bitmapByteArray);
        Bitmap bitmapProfile = BitmapFactory.decodeStream(arrayInputStream);

        ImageView img2=findViewById(R.id.imageView);
        // img.setBackgroundDrawable(new BitmapDrawable(bitmapProfile));
        img2.setImageBitmap(bitmapProfile);

    }
}
