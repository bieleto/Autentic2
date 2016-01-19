package com.example.biel.autentic;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ViewFlipper;

import com.example.biel.autentic.model.BerenarDAO;
import com.example.biel.autentic.objects.Berenar;
import com.example.biel.autentic.server.Server;
import com.example.biel.autentic.utils.Constants;

import java.util.ArrayList;
import java.util.List;

/**
 *
 *
 * Created by biel on 15/01/16.
 */
public class Dynamicentral extends AppCompatActivity{

    private List<Berenar> berenars; // = new ArrayList<Berenar>();

    private int index = 0;

    private ViewFlipper mVistaFlipper;
    private Button mAnteriorButton;
    private Button mSeguentButton;
 //// altres declaracions
    private int idBerenar;
    private BerenarDAO berenarDAO;
    private Server server;
    private int estat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dynamicentral);
        estat=0;
        // a n'aquest Layout de moment no tenim la ActionBar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        server = new Server (this);
        berenars = new ArrayList<Berenar>();
        getBerenarByState();
        



        mVistaFlipper = (ViewFlipper) findViewById(R.id.viewFlipper);//Declarat al XML
        mAnteriorButton = (Button) findViewById(R.id.botoanterior);//declarat al XML
        mSeguentButton = (Button) findViewById(R.id.botoseguent);//declarat al XML

        ImageView image = getNovaImatgeView();
        image.setImageResource(R.drawable.frit1);//ic_launcher...?

        mVistaFlipper.addView(image); // a l'objecte creat a XML li posam la imatge rescatada anteriorment
        mSeguentButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                ImageView imatgeSeguent = getNovaImatgeView();// posam la nova imatge
                mVistaFlipper.addView(imatgeSeguent);//Carregam la imatge nova
                mVistaFlipper.showNext();// mostram la imatge nova
            }


        });

        mAnteriorButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mVistaFlipper.showPrevious();//Crec que només feim el previous pq no hem perdut l'anterior imatge
            }
        });


    }

    protected ImageView getNovaImatgeView() {// Aquí retorn la imatge que he d'agafar ara intentarem agafar-la de la base de dades.

        ImageView image = new ImageView(getApplicationContext());
        image.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        return image;
    }



    private void getBerenarByState(){

        switch (estat) {
            case Constants.ESTAT_NOU:
                berenars = server.getBerenarOrderByData();
                break;
            case Constants.ESTAT_SEGUIDORS:
                //De moment no el desenvolup
                break;
            case Constants.ESTAT_APROP:
                //De moment no el desenvolup
                break;
            case Constants.ESTAT_JO:
                berenars = server.getBerenarByUser(1);// De moment ho pos a ma pq jo seré l'usuari 1
                break;
            default:
                // En principi no entrarà aquí
                break;



        }
    }
}
