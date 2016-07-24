package com.example.js.convertisseur;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity  {


    private float moneyD;
    private float moneyCFA;
    private Button butConv= null;

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


        final EditText numDol = (EditText) findViewById(R.id.editText);
        final TextView mCFA = (TextView)findViewById(R.id.textView4);

        butConv = (Button) findViewById(R.id.button);
        butConv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String mDollar = numDol.getText().toString();
                moneyD=Float.parseFloat(mDollar);
                if(moneyD<0)
                {
                    Toast toast = Toast.makeText(getApplicationContext(), "On ne convertit pas les négatifs :p ", Toast.LENGTH_LONG);
                    toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
                    toast.show();
                }
                else {
                    moneyCFA= (float) (moneyD*586.84);
                    mCFA.setText(Float.toString(moneyCFA));

                    if(moneyD<500)
                    {
                        Toast toast = Toast.makeText(getApplicationContext(), "Même pas le prix d'un Kebab :p", Toast.LENGTH_LONG);
                        toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
                        toast.show();
                    }

                    if(moneyD>500)
                    {
                        Toast toast = Toast.makeText(getApplicationContext(), "ça en fait de l'argent hein ;)", Toast.LENGTH_LONG);
                        toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
                        toast.show();
                    }
                }


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
}
