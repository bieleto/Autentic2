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

import com.example.biel.autentic.utils.Constants;

/**
 * Created by biel on 28/11/15.
 * És per consultar tota la informació d'un plat. La del perfil d'usuari tendra el mateix format en quan al xml.
 */
public class FitxaPlat extends AppCompatActivity  {

        private int idBerenar;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            //Aquest fitxa plat és el xml
            setContentView(R.layout.fitxa_plat);

            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setHomeButtonEnabled(true);

            idBerenar = (Integer) getIntent().getExtras().get(Constants.BERENAR_ID);

        }
    //és el menu de la action bar principal
    @Override
    public boolean onCreateOptionsMenu (Menu menu){
        //Farem un Inflate que en teoria ficarà els items que volguem dins la action bar que ja tenim
        getMenuInflater().inflate(R.menu.menu_principal, menu);

        return true;
    }



    @Override
    public boolean onOptionsItemSelected (MenuItem item){
        int id = item.getItemId();

        Log.e("fitxa Menu ", " " + id);

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
                Toast.makeText(this,"Acció fitxa plat Cerca", Toast.LENGTH_SHORT).show();
                return true;
            case android.R.id.home:

                Intent fitxaPlat = new Intent(this, Central.class);
                startActivity(fitxaPlat);
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


}
