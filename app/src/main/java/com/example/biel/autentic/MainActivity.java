package com.example.biel.autentic;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Referenciam el primer boto de la vista xml fer-ho 4 pics per el 4 botons
        ImageButton botocentral = (ImageButton) findViewById(R.id.botocentral);

        //Quan pitjam el boto que feim? lisener

        botocentral.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // ha d'anar a una altre activitat feim un Intent que és per canviar d'activitats
                // on estic .this on he d'anar que és el .java
                Intent central = new Intent(MainActivity.this, central.class);
                // Ara l'executam. Adalt el cream
                startActivity(central);
            }
        });




    }






}
