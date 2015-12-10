package com.example.biel.autentic;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;
import android.widget.Toolbar;


//És la pantalla principal on surtirà el menu principal que seran X botons.
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//Afegit dia 9 12 15 se podrà borrar segurament//
        //he de crear el toolbar inicial d'alt on posaré la cerca mapa foto refresca.
        //Aquesta declaració necessita fer
       // Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar)
////////////////////////////////////////////





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
/*Afegit dia 9 12 15 se podrà borrar segurament
@Override
    public boolean onOptionsItemSelection (MenuItem item){
//Elements de la barra d'acció principal. Botons on podrem clicar
// Com hem espicifat una activitat principal al Android Manifest
    int id = item.getItemId();
    //Feim els casos del que poden pitjar
    switch (item.getItemId()){
        case R.id.action_map:
            Toast.makeText(this, "Acción Mapa", Toast.LENGTH_SHORT).show();
            return true;

        default:
            return super.onOptionsItemSelected(item);

    }


}

Afegit dia 9 12 15 se podrà borrar segurament */

    // 9-12-15 Intent fer un submenú en botons a la action bar principal on hi ha el nom del programa.
    @Override
    public boolean onCreateOptionsMenu (Menu menu){
        //Farem un Inflate que en teoria ficarà els items que volguem dins la action bar que ja tenim
        getMenuInflater().inflate(R.menu.menu_principal, menu);
        return true;
    }


}
