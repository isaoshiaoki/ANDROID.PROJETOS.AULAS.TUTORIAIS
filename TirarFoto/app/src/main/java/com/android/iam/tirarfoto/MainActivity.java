package com.android.iam.tirarfoto;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static android.media.MediaRecorder.VideoSource.CAMERA;

public class MainActivity extends AppCompatActivity {
    private File arquivoFoto = null;
  public ImageView imagem;
   private Button selecionaImagem,tiraFoto,tiraFotoSalva;

    private final int GALERIA_IMAGENS=1;
    private final int PERMISSAO_REQUEST=2;
    private final int TIRAR_FOTO=3;
    private final int CAMERA=4;

    //////////////////////PERMISSOES/////////////////////////////////////////////

    // Solicita as permissões
    private String[] permissoesNecessarias = new String[]{
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE,
            Manifest.permission.CAMERA

            //tem q  colocar no manifet tb
    };

///////////////////////////////////////////////////////////////////////////////




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imagem=(ImageView) findViewById(R.id.imageView);

        selecionaImagem=(Button) findViewById(R.id.selecionaID);
        tiraFoto=(Button) findViewById(R.id.tiraFotoID);

        tiraFotoSalva=(Button) findViewById(R.id.tiraSalvaBtnID);

        /////////////PERMISSOES///////////////////////

        //////////////////////PERMISSOES/////////////////////////////////////////////

        //Validar permissões
        PermissionUtils.validarPermissoes(permissoesNecessarias, this, 10);

///////////////////////////////////////////////////////////////////////////////


/*
        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.READ_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                    Manifest.permission.READ_EXTERNAL_STORAGE)) {
            } else {
                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
                        PERMISSAO_REQUEST);
            }
        }


        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.WRITE_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {




            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                    Manifest.permission.WRITE_EXTERNAL_STORAGE)) {


            } else {
                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},
                        PERMISSAO_REQUEST);
            }



        }*/


        //////////////////////////////////////////////


////////////////////////////Seleciona imagem/////////////////////////////////////////

selecionaImagem.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {

        Intent intent = new Intent(Intent.ACTION_PICK,
                android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(intent,  GALERIA_IMAGENS);



    }
});

////////////////////////////////Tira foto///////////////////////////////////////////////
        tiraFoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//só tira a foto
               tirarFoto();

            }
        });



////////////////////////////Tira foto e salva/////////////////////////////////////////

       tiraFotoSalva.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //tira e salva a foto
                tirarFotoESalvar();


            }
        });

//////////////////////////////////////////////



        }//oncreate fim


//https://www.youtube.com/watch?v=AnNpUGyryiE

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

      //para galeria
        if (resultCode == RESULT_OK && requestCode == GALERIA_IMAGENS) {
            Uri selectedImage = data.getData();
            String[] filePath = { MediaStore.Images.Media.DATA };
            Cursor c = getContentResolver().query(selectedImage,filePath, null, null, null);
            c.moveToFirst();
            int columnIndex = c.getColumnIndex(filePath[0]);
            String picturePath = c.getString(columnIndex);
            c.close();
            Bitmap thumbnail = (BitmapFactory.decodeFile(picturePath));
            imagem.setImageBitmap(thumbnail);


        }

        //para camera
        if (requestCode == TIRAR_FOTO && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            imagem.setImageBitmap(imageBitmap);
        }




        if (requestCode == CAMERA && resultCode == RESULT_OK) {
            sendBroadcast(new Intent(
                    Intent.ACTION_MEDIA_SCANNER_SCAN_FILE,
                    Uri.fromFile(arquivoFoto))
            );
            exibirImagem();
        }
















    }














///////////////////////RESPOSTA DA PERMISSÂO////////////////////////////////

//////////////////////PERMISSOES////////////////////////////////////////////////////////////////////


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        for ( int permissaoResultado : grantResults ){
            if ( permissaoResultado == PackageManager.PERMISSION_DENIED ){
                alertaValidacaoPermissao();
            }
        }

    }

    private void alertaValidacaoPermissao(){

        android.support.v7.app.AlertDialog.Builder builder = new android.support.v7.app.AlertDialog.Builder( this );
        builder.setTitle("Permissões Negadas");
        builder.setMessage("Para utilizar o app é necessário aceitar as permissões");
        builder.setCancelable(false);
        builder.setPositiveButton("Confirmar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });

        android.support.v7.app.AlertDialog dialog = builder.create();
        dialog.show();

    }

////////////////////////////////////////////////////////////////////////////////////////////////////
     ///////////////////////////////////////////////////////////////////////////////////







    private File criarArquivo() throws IOException {
        String timeStamp = new
                SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        File pasta = Environment.getExternalStoragePublicDirectory(
                Environment.DIRECTORY_PICTURES);
        File imagem = new File(pasta.getPath() + File.separator
                + "JPG_" + timeStamp + ".jpg");
        return imagem;
    }

//https://www.dropbox.com/s/xcnjugj0jbqnp7f/04%20-%20Tirando%20fotos.pdf?dl=0
//https://www.youtube.com/watch?v=o0ZKQITPnpk
////////////////////////METODO PARA TIRAR FOTO//////////////////////////////////////////////////



private void tirarFoto() {


    Intent takePictureIntent = new
            Intent(MediaStore.ACTION_IMAGE_CAPTURE);
    if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
        startActivityForResult(takePictureIntent, TIRAR_FOTO);
    }
}



    private void tirarFotoESalvar2() {


        try {
            arquivoFoto = criarArquivo();
        } catch (IOException ex) {
// Manipulação em caso de falha de criação do arquivo
        }

    }




    private void tirarFotoESalvar() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            try {
                arquivoFoto = criarArquivo();
            } catch (IOException ex) {
// Manipulação em caso de falha de criação do arquivo
            }
            if (arquivoFoto != null) {
                Uri photoURI = FileProvider.getUriForFile(getBaseContext(),
                        getBaseContext().getApplicationContext().getPackageName() +
                                ".provider", arquivoFoto);
                takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, photoURI);
                startActivityForResult(takePictureIntent,CAMERA);
            }
        }
    }







//////////////////////////////////////////////////////////////////////////

    private void exibirImagem() {
        int targetW = imagem.getWidth();
        int targetH = imagem.getHeight();
        BitmapFactory.Options bmOptions = new BitmapFactory.Options();
        bmOptions.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(arquivoFoto.getAbsolutePath(), bmOptions);
        int photoW = bmOptions.outWidth;
        int photoH = bmOptions.outHeight;
        int scaleFactor = Math.min(photoW/targetW, photoH/targetH);
        bmOptions.inJustDecodeBounds = false;
        bmOptions.inSampleSize = scaleFactor;
        Bitmap bitmap =
                BitmapFactory.decodeFile(arquivoFoto.getAbsolutePath(), bmOptions);
        imagem.setImageBitmap(bitmap);
    }










        }//fim

