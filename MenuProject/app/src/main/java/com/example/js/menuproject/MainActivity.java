package com.example.js.menuproject;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {

    private Button butSMS = null;
    private Button butPHONE = null;
    private Button butSHARE = null;
    private Button butNAC = null;
    private Button butWEB = null;
    private Button butMAP = null;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        butSMS = (Button) findViewById(R.id.bSMS);
        butSMS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Intent intent = new Intent(Intent.ACTION_SENDTO);
                intent.setData(Uri.parse("smsto:"+ Uri.encode("782912730")));
                intent.putExtra("sms_body","Bonjour Wali ti mbi, c'est Jimmy Glorial Balezou");
                startActivity(intent);
            }
        });

        butPHONE = (Button) findViewById(R.id.bPHONE);
        butPHONE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:782912730"));
                startActivity(intent);
            }
        });


        butWEB = (Button) findViewById(R.id.bWEB);
        butWEB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Intent intent = new Intent(Intent.ACTION_VIEW,
                Uri.parse("http://esmt.sn"));
                startActivity(intent);
            }
        });

        butMAP = (Button) findViewById(R.id.bMAP);
        butMAP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String geoUri= String.format ("geo:4.3612200,18.5549600 ");
                Uri geo = Uri.parse(geoUri);
                Intent geoMap= new Intent(Intent.ACTION_VIEW,geo);
                startActivity(geoMap);
            }
        });

        butSHARE = (Button) findViewById(R.id.bSHARE);
        butSHARE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Intent intent= new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                intent.putExtra(Intent.EXTRA_SUBJECT,"JSProd");
                intent.putExtra(Intent.EXTRA_SUBJECT,"Join The Dream");
                startActivity(Intent.createChooser(intent,"Share The Love"));
            }
        });


        butNAC = (Button) findViewById(R.id.bNAC);
        butNAC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Intent intent = new Intent(MainActivity.this, NewActivity.class);
                startActivity(intent);
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

        if (id == R.id.action_help) {
            final Intent intent = new Intent(MainActivity.this, HelpActivity.class);
            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }
}
