package com.example.biel.autentic.model;

import android.content.Context;
//Context és un altre objecte de Java que emprarem
import android.database.Cursor;
//Cursor és un objecta de java que emprarem
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import com.example.biel.autentic.Central;
import com.example.biel.autentic.objects.Berenar;
import com.example.biel.autentic.utils.Constants;

import java.util.ArrayList;
import java.util.List;
//List és un objecte de java que ens permet fer llistes d'altres objectes

/**
 * Created by biel on 30/12/15.
 */
public class BerenarDAO {

    protected SQLiteDatabase database;
    private TablesHelper tablesHelper;
    private Context context;



    public BerenarDAO(Context context) {
        this.context = context;
        tablesHelper = TablesHelper.getHelper(context);
       // open();

    }

    public void open()  {//throws SQLException//Llevar-ho

        if(tablesHelper == null) {
            tablesHelper = TablesHelper.getHelper(context);
        }

        database = tablesHelper.getWritableDatabase();

    }

    public void close() {
        tablesHelper.close();
    }

    public boolean createBerenar(Berenar berenar) {
//No crearem cap berenar pq feim els inserts directament per carregar els exemples creats.
        //ContentValues values = new ContentValues();
        //values.put(Constants.BERENAR_ID, berenar.getIdBerenar());


        //database.insert(Constants.TABLE_BERENAR, null, values);

        return true;

    }

    public boolean deleteBerenar(int idBerenar) {
//De moment tampoc ens fa falta programar-ho
        return true;
    }

    public boolean updateBerenar(int idBerenar) {
//De moment tampoc ens fa falta programar-ho.
        return true;
    }

    /**
     * Ara hem de implementar tots els get Berenars que emprarem dins la aplicació segons els botons del menu o accions que poguem fer
     * @param idBerenar
     * @return
     */
        public Berenar getBerenar(int idBerenar) {
            // entra un idBerenar i volem retornar l'objecte Berenar d'aquest idBerenar per anar a la seva fitxa
            Berenar fitxaberenar = new Berenar();

                 String selectQuery = "SELECT * FROM " + Constants.TABLE_BERENAR
                    + " WHERE " + Constants.TABLE_BERENAR + "." + Constants.BERENAR_ID
                    + " = " + idBerenar;



            Cursor c = database.rawQuery(selectQuery, null);

            if (c.moveToFirst()){

                    //Aquí rescat tots els parametres que vull
                    fitxaberenar.setIdBerenar(c.getInt(c.getColumnIndex(Constants.BERENAR_ID)));
                fitxaberenar.setNom(c.getString(c.getColumnIndex(Constants.BERENAR_NOM)));
                    // La imatge serà String i en la part de representar ja agafarem aquest String i posarem l'imatge
                fitxaberenar.setFoto(c.getString(c.getColumnIndex(Constants.BERENAR_FOTO)));
                fitxaberenar.setData(c.getLong(c.getColumnIndex(Constants.BERENAR_DATA)));
                fitxaberenar.setTipus(c.getString(c.getColumnIndex(Constants.BERENAR_TIPUS)));
                fitxaberenar.setDescripcio(c.getString(c.getColumnIndex(Constants.BERENAR_DESCRIPCIO)));

            }
            return fitxaberenar;

        }
    public List<Berenar> getBerenarByUser(int idUser){
        List<Berenar> berenars =new ArrayList<Berenar>();

//Select que treu tots els idBerenar d'un idUsuari i els ordena per data

        String selectQuery = "SELECT * FROM " + Constants.TABLE_BERENAR
                + " INNER JOIN " + Constants.TABLE_USUARI_BERENAR
                + " ON " + Constants.TABLE_BERENAR + "." + Constants.BERENAR_ID
                + " = " + Constants.TABLE_USUARI_BERENAR + "." + Constants.BERENAR_ID
                + " WHERE " + Constants.TABLE_USUARI_BERENAR + "." + Constants.USUARI_ID
                + " = " + idUser
                + " ORDER BY " + Constants.TABLE_BERENAR + "." + Constants.BERENAR_DATA;

        //Ficam el resultat a l'objecte cursos c
        Cursor c= database.rawQuery(selectQuery, null);

        //Ara analitzarem l'objecte cursos
        if (c.moveToFirst()){
            do {
                Berenar berenar = new Berenar();
                //Aquí rescat tots els parametres que vull
                berenar.setIdBerenar(c.getInt(c.getColumnIndex(Constants.BERENAR_ID)));
                berenar.setNom(c.getString(c.getColumnIndex(Constants.BERENAR_NOM)));
                // La imatge serà String i en la part de representar ja agafarem aquest String i posarem l'imatge
                berenar.setFoto(c.getString(c.getColumnIndex(Constants.BERENAR_FOTO)));
                berenar.setData(c.getLong(c.getColumnIndex(Constants.BERENAR_DATA)));
                berenar.setTipus(c.getString(c.getColumnIndex(Constants.BERENAR_TIPUS)));

                berenars.add(berenar);

            }while (c.moveToNext());
        }
        return berenars;

    }

    public List<Berenar> getBerenarByBar(int idBar) {
        //De moment no l'implementaré
        return null;
    }
/*Documentació
* Conqué tenim un bbdd d'exemple amb 15 elements màxim ho feim així. En la realitat hauriem de implementar un sistema pq retornes un màxim
* dins la cerca per exemple els primers 50 items...
* */
    public List<Berenar> getBerenarOrderByData() {
        //Seria el boto nou
        List<Berenar> berenars = new ArrayList<Berenar>();

        String selectQuery = "SELECT * FROM " + Constants.TABLE_BERENAR
                + " ORDER BY " + Constants.TABLE_BERENAR + "." + Constants.BERENAR_DATA
                + " DESC ";

        Cursor c = database.rawQuery(selectQuery, null);

        if (c.moveToFirst()){
            do {
                Berenar berenar = new Berenar();
                //Aquí rescat tots els parametres que vull
                berenar.setIdBerenar(c.getInt(c.getColumnIndex(Constants.BERENAR_ID)));
                berenar.setNom(c.getString(c.getColumnIndex(Constants.BERENAR_NOM)));
                // La imatge serà String i en la part de representar ja agafarem aquest String i posarem l'imatge
                berenar.setFoto(c.getString(c.getColumnIndex(Constants.BERENAR_FOTO)));
                berenar.setData(c.getLong(c.getColumnIndex(Constants.BERENAR_DATA)));
                berenar.setTipus(c.getString(c.getColumnIndex(Constants.BERENAR_TIPUS)));

                berenars.add(berenar);
            } while (c.moveToNext());

        }
        return berenars;

    }
    /* per les imatges
    try
    {
        // get input stream
        InputStream ims = getAssets().open("avatar.jpg");
        // load image as Drawable
        Drawable d = Drawable.createFromStream(ims, null);
        // set image to ImageView
        mImage.setImageDrawable(d);
    }
    catch(IOException ex)
    {
        return;
    }
*/

    public List<Berenar> getBerenarBySeguesc(int idUser) {// EL idUser és el meu pq esteim al boto Seguesc
        //Seria el boto Seguesc de moment ho faré com si aquesta persona seguis els berenars d'un usuari
        List<Berenar> berenars = new ArrayList<Berenar>();
        List<Berenar> berenars2 = new ArrayList<Berenar>();
        List<List<Berenar>> Berenarsjunts =new ArrayList<List<Berenar>>();

        String selectQuery = "SELECT * FROM " + Constants.TABLE_USUARI
                + " INNER JOIN " + Constants.TABLE_SEGUIDOR
                + " ON " + Constants.TABLE_USUARI + "." + Constants.USUARI_SEGUIDOR
                + " = " + Constants.TABLE_SEGUIDOR + "." + Constants.SEGUIDOR_ID
                + " WHERE " + Constants.TABLE_USUARI + "." + Constants.USUARI_ID
                + " = " + idUser;

        Cursor c = database.rawQuery(selectQuery, null);

        if (c.moveToFirst()){
            do {

                //Aquí llegim els berenars de l'usuari que seguim
                // Si esteim aquí de dins és pq c te alguna cosa
                berenars = getBerenarByUser(c.getInt(c.getColumnIndex(Constants.SEGUIDOR_USUARI_ID)));
                Berenarsjunts.add(berenars);

/*
*
* El problema és que vamos MATXACANDO la lista berenars con los berenars de cada seguidor però nos puede servir para el caso
* en que solo tengo un seguidor.
 * IMPORTANT!!!!!!!!!!!!!!!!!!!!!!!!!! AVERIGUAR COMO PASAR A UN ARRAY DE BERENAR UN ARRAY DE ARRAYS DE BERENARS
*
* */
               // berenars.add(berenar);

            } while (c.moveToNext());

        }
        return berenars;

    }


}
