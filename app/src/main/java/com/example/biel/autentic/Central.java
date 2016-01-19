package com.example.biel.autentic;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;


import com.example.biel.autentic.model.BerenarDAO;
import com.example.biel.autentic.objects.Berenar;
import com.example.biel.autentic.server.Server;
import com.example.biel.autentic.utils.Constants;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by biel on 28/11/15.
 * És la pantalla de navegació on navegarem per  veure els resultats segons els nostres criteris de cerca
 * El més visitat, etc...

 */


public class Central extends AppCompatActivity {

    private int idBerenar;
    private BerenarDAO berenarDAO;
    private Server server;
    private List<Berenar> berenars;
    private int estat;

// sempre copiam lo mateix onCreate buit i posam que el R.layout és el nou xml

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.central);
        estat = 0;
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        server = new Server(this);
        berenars = new ArrayList<Berenar>();

        getBerenarByState();
       /*Ens dona error quan entra a central a una d'aquestes pases!!!!!!!!!! Revisar

        getBerenarByState();
*/


//referenciam les imatges que tenim al central.xml per fer les botons

        ImageView imatge1 = (ImageView) findViewById(R.id.botoMillor);
        //Per quan pitgin l'imatge faci algo
        imatge1.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                // dins parentesis posam sempre on esteim i on anam
                Intent fitxaPlat = new Intent(Central.this, FitxaPlat.class);
                fitxaPlat.putExtra(Constants.BERENAR_ID, idBerenar);

                //començam activitat i entre parentesi el nom del Inent creat fitxa_plat
                startActivity(fitxaPlat);

                return false; //ve per defecta ja veurem si el posam a true
            }
        });

    }

//és el menu de la action bar principal
    @Override
    public boolean onCreateOptionsMenu (Menu menu){
        //Farem un Inflate que en teoria ficarà els items que volguem dins la action bar que ja tenim
        getMenuInflater().inflate(R.menu.menu_principal, menu);
        return true;
    }




    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        Log.e("central Menu ", " " + id);

//per si el necessit per llegir si pitja damunt autentic---

        switch (item.getItemId()){
            case R.id.action_camera:
                Toast.makeText(this, "Acció Càmera", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.action_refresh:
                Toast.makeText(this,"Acció Refresca", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.action_map:
                Toast.makeText(this,"Acció Mapa", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.action_cerca:
                Toast.makeText(this,"Acció Cerca", Toast.LENGTH_SHORT).show();
                return true;
            case R.mipmap.ic_launcher:
                Toast.makeText(this,"Acció principal",Toast.LENGTH_SHORT).show();
                return true;
            case android.R.id.home:
                Intent mainActivity = new Intent(this, MainActivity.class);
                // Ara l'executam. Adalt el cream
                startActivity(mainActivity);
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
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
                //berenars = server.getBerenarByUser(1);// De moment ho pos a ma pq jo seré l'usuari 1
                break;
            default:
                // En principi no entrarà aquí
                break;
    }

        Toast.makeText(Central.this,"Faig el getBerenarByState", Toast.LENGTH_SHORT).show();


    }


}
