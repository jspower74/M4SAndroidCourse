package com.example.js.asynctaskproject;

import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends AppCompatActivity {


    String lien = "https://raw.githubusercontent.com/jspower74/M4SAndroidCourse/1df1522702e6f6ca1664e3cd45d2f0e3ee61e64c/Bangui.png";
    ImageView ImageBangui;
    ProgressDialog MessProg;
    Button butImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        //Localiser l'image
        ImageBangui = (ImageView) findViewById(R.id.image);

        // Localiser le boutton
        butImage = (Button) findViewById(R.id.button);

        // Gestion du clic du boutton pour le téléchargement de l'image
        butImage.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {

                // Execution de l'AsyncTask
                new ChargementImage().execute(lien);
            }
        });

    }





    // Télécharger l'ImageBangui avec AsyncTask
    private class ChargementImage extends AsyncTask<String, Void, Bitmap> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            // Creation d'un message de progression du téléchargement de l'image
            MessProg = new ProgressDialog(MainActivity.this);
            // Mettre un titre à la boite de dialogue du téléchargement de l'image
            MessProg.setTitle("Image de Bangui (R.C.A)");
            // Créer un message de progression du téléchargement
            MessProg.setMessage("Chargement ...");
            MessProg.setIndeterminate(false);
            // Montrer la boite de dialogue
            MessProg.show();
        }

        @Override
        protected Bitmap doInBackground(String... URL) {


            Bitmap bitmap = null;
            try {
                // Télécgargement de l'image
                URL url = new URL(lien);
                HttpURLConnection con = (HttpURLConnection) url.openConnection();

                //Vérification de la connexion
                if (con.getResponseCode() != HttpURLConnection.HTTP_OK) {
                    //Message appelant à la connexion
                    Toast.makeText(getApplicationContext(),"connecter d'abord",Toast.LENGTH_SHORT).show();
                    MessProg.dismiss();
                }
                //Decodage du Bitmap
                InputStream is = con.getInputStream();
                bitmap = BitmapFactory.decodeStream(is);
                is.close();

            } catch (Exception e) {
                Log.e("Image", "Le chargement de l'image à échouer", e);
                Log.e("error", e.getMessage());

            }

            return bitmap;
        }

        @Override
        protected void onPostExecute(Bitmap result) {
            // Mettre l'image dans l'image view
            ImageBangui.setImageBitmap(result);
            // Fermer la boite de dialogue
            MessProg.dismiss();

        }
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
        // automatically handle clicks on the Home/Up butImage, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
