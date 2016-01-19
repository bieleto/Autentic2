package com.example.biel.autentic;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;


//És la pantalla principal on surtirà el menu principal que seran X botons.
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Referenciam el primer boto de la vista xml fer-ho 4 pics per el 4 botons
        ImageButton botocentral = (ImageButton) findViewById(R.id.botocentral);

        ImageButton botoDynamiccentral = (ImageButton) findViewById(R.id.boto_notificacions);




        botocentral.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"He pitjat boto Explorar", Toast.LENGTH_SHORT).show();
                // ha d'anar a una altre activitat feim un Intent que és per canviar d'activitats
                // on estic .this on he d'anar que és el .java
                Intent central = new Intent(MainActivity.this, Central.class);
                // Ara l'executam. Adalt el cream
                startActivity(central);
                finish();

            }
        });

        botoDynamiccentral.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"He pitjat boto notificacions", Toast.LENGTH_SHORT).show();
                Intent dynamiccentral = new Intent(MainActivity.this, Dynamicentral.class);
                startActivity(dynamiccentral);
                finish();
            }
        });

    }


    // 9-12-15 Intent fer un submenú en botons a la action bar principal on hi ha el nom del programa.
    @Override
    public boolean onCreateOptionsMenu (Menu menu){
        //Farem un Inflate que en teoria ficarà els items que volguem dins la action bar que ja tenim
        getMenuInflater().inflate(R.menu.menu_principal, menu);

        return true;
    }



    @Override
    public boolean onOptionsItemSelected (MenuItem item){
        int id = item.getItemId();
        Log.e("MainActivity Menu ", " " + id);

//per si el necessit per llegir si pitja damunt autentic---


        switch (item.getItemId()){
            case R.id.action_camera:
                Toast.makeText(this,"Acció Càmera", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.action_refresh:
                Toast.makeText(this,"Acció Refresca", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.action_map:
                Toast.makeText(this,"Acció Mapa", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.action_cerca:
                Toast.makeText(this,"Acció Cerca principal", Toast.LENGTH_SHORT).show();
                return true;
            //case android.R.id.home:
              //  Toast.makeText(this,"Acció principal",Toast.LENGTH_SHORT).show();
                //return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }



}
