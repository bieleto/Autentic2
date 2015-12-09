package com.example.biel.autentic;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

/**
 * Created by biel on 28/11/15.
 * És la pantalla de navegació on navegarem per  veure els resultats segons els nostres criteris de cerca
 * El més visitat, etc...

 */


public class central extends AppCompatActivity {

// sempre copiam lo mateix onCreate buit i posam que el R.layout és el nou xml

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.central);

//referenciam les imatges que tenim al central.xml per fer les botons

        ImageView imatge1 = (ImageView) findViewById(R.id.imageButton4);
        //Per quan pitgin l'imatge faci algo
        imatge1.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                // dins parentesis posam sempre on esteim i on anam
                Intent fitxa_plat = new Intent(central.this, fitxa_plat.class);
                //començam activitat i entre parentesi el nom del Inent creat fitxa_plat
                startActivity(fitxa_plat);

                return false; //ve per defecta ja veurem si el posam a true
            }
        });




    }



}
