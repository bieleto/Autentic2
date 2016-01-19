package com.example.biel.autentic.model;
import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import com.example.biel.autentic.Central;
import com.example.biel.autentic.utils.Constants;
import java.sql.Blob; // És per si tractam les fotografies d'aquest tipus.

//Aquí definim el primer nivell de la base de dades amb els trtibuts que pens que son atòmics on en teoria cap atribut pot ser nul quan se donin d'alta sino estaran a un altre nivell
// al berenar.java bar.java usuari.java i tots els elements tendran el mateix nombre de elelements
public class TablesHelper extends SQLiteOpenHelper {

    // Logcat tag "L'etiqueta de registre"
    private static final String LOG = "DatabaseHelper";
    private static TablesHelper instance;

// IF NOT EXISTS DONARÀ ERROR SI LES TAULES JA ESTAN CREADES.
    // String creació de taula  berenar IF NOT EXISTS
    private static final String CREATE_TABLE_BERENAR = "CREATE TABLE " + Constants.TABLE_BERENAR + "("
            + Constants.BERENAR_ID + " INTEGER PRIMARY KEY, "
            + Constants.BERENAR_TIPUS + " TEXT,"
            + Constants.BERENAR_NOM + " TEXT, "
            + Constants.BERENAR_DESCRIPCIO + " TEXT,"
            + Constants.BERENAR_FOTO + " BLOB,"
            + Constants.BERENAR_DATA + " LONG" + ")"; // HO FEIM LONG PERQUÈ DATETIME A L'HORA DE COMPARAR ORDENAR ETC POT DONAR PROBLEMES SEGONS ELS FOROS CONSULTATS


    // BLOB és un sistema per carregar les fotogrofaies, si ho tenguessim dins un servidor envers de blob
    // podriem posar també el link de les fotos

    // String creació taula bar_berenar IF NOT EXISTS
    private static final String CREATE_TABLE_BAR_BERENAR = "CREATE TABLE " + Constants.TABLE_BAR_BERENAR + "("
            +Constants.BAR_ID+" integer FOREIGNKEY REFERENCES " + Constants.TABLE_BAR + "("+ Constants.BAR_ID+"),"
            +Constants.BERENAR_ID+" integer FOREIGNKEY REFERENCES " + Constants.TABLE_BERENAR + "("+ Constants.BERENAR_ID+")"+")";
           // + Constants.BAR_ID + " INTEGER PRIMARY KEY,"
           // + Constants.BERENAR_ID + " INTEGER FOREING KEY"+ ")";


    // String creació taula bar IF NOT EXISTS
    private static final String CREATE_TABLE_BAR = "CREATE TABLE  " + Constants.TABLE_BAR + "("
            + Constants.BAR_ID + " INTEGER PRIMARY KEY,"
            + Constants.BAR_NOM + " TEXT,"
            + Constants.BAR_POBLE_CIUTAT + " TEXT,"
            + Constants.BAR_DIRECCIO + " TEXT"+ ")";


    // String creació taula seguidor IF NOT EXISTS
    private static final String CREATE_TABLE_SEGUIDOR = "CREATE TABLE " + Constants.TABLE_SEGUIDOR + "("
            +Constants.SEGUIDOR_ID+" integer FOREIGNKEY REFERENCES " + Constants.TABLE_USUARI + "("+ Constants.USUARI_SEGUIDOR+"),"
            +Constants.SEGUIDOR_USUARI_ID+" integer FOREIGNKEY REFERENCES " + Constants.TABLE_USUARI + "("+ Constants.USUARI_ID+")"+")";
//           + Constants.SEGUIDOR_ID + " INTEGER PRIMARY KEY,"
//   + Constants.SEGUIDOR_USUARI_ID + " INTEGER FOREIGN KEY"+ ")";

    // String creació taula usuari IF NOT EXISTS
    private static final String CREATE_TABLE_USUARI = "CREATE TABLE " + Constants.TABLE_USUARI + "("
            + Constants.USUARI_ID + " INTEGER PRIMARY KEY,"
            + Constants.USUARI_NOM + " TEXT,"
            + Constants.USUARI_CORREU + " TEXT,"
            +Constants.USUARI_SEGUIDOR+" integer FOREIGNKEY REFERENCES " + Constants.TABLE_SEGUIDOR + "("+ Constants.SEGUIDOR_ID+")"+")";
// FOREIGN KEY(salesperson_id) REFERENCES salespeople(id));


    // String creació taula usuari berenar  IF NOT EXISTS
    private static final String CREATE_TABLE_USUARI_BERENAR = "CREATE TABLE " + Constants.TABLE_USUARI_BERENAR + "("
            +Constants.USUARI_BERENAR_ID_USUARI+" integer FOREIGNKEY REFERENCES " + Constants.TABLE_USUARI + "("+ Constants.USUARI_ID+"),"
            +Constants.USUARI_BERENAR_ID_BERENAR+" integer FOREIGNKEY REFERENCES " + Constants.TABLE_BERENAR + "("+ Constants.BERENAR_ID+")"+")";
//+ Constants.USUARI_BERENAR_ID_USUARI + " INTEGER PRIMARY KEY,"


    // String creació taula berenar criteri IF NOT EXISTS
    private static final String CREATE_TABLE_BERENAR_CRITERI = "CREATE TABLE " + Constants.TABLE_BERENAR_CRITERI + "("
            +Constants.BERENAR_CRITERI_ID_BERENAR+" integer FOREIGNKEY REFERENCES " + Constants.TABLE_BERENAR + "("+ Constants.BERENAR_ID+"),"
            +Constants.BERENAR_CRITERI_ID_CRITERI+" integer FOREIGNKEY REFERENCES " + Constants.TABLE_CRITERI + "("+ Constants.CRITERI_ID+")"+")";




    // String creació taula criteri IF NOT EXISTS
    private static final String CREATE_TABLE_CRITERI = "CREATE TABLE " + Constants.TABLE_CRITERI + "("
            + Constants.CRITERI_ID + " INTEGER PRIMARY KEY,"
            + Constants.CRITERI_NOM + " TEXT,"
            + Constants.CRITERI_VALOR + " INTEGER"+ ")";



    public TablesHelper(Context context) {
        super(context, Constants.DATABASE_NAME, null, Constants.DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        // cream les taules requerides
        db.execSQL(CREATE_TABLE_BERENAR);
        db.execSQL(CREATE_TABLE_USUARI);
        db.execSQL(CREATE_TABLE_CRITERI);
        db.execSQL(CREATE_TABLE_BAR);
        db.execSQL(CREATE_TABLE_BERENAR_CRITERI);
        db.execSQL(CREATE_TABLE_BAR_BERENAR);
        db.execSQL(CREATE_TABLE_SEGUIDOR);
        db.execSQL(CREATE_TABLE_USUARI_BERENAR);

// Aquí farem els inserts a saco dels meus exemples a la bd

        System.out.println(this.getClass().toString() + " onCreate");

//////////// Mirar de primer fer els inserts de taules abans de les taulesrelacions com BAR-BERENAR ///////

        /////9 BERENARS///////
// System.currentTimeMillis() és com ficarem la DATA

        insertTableBerenar(db, 101, "LLONGUET", "SERRANITO",
                "M'encanta el llonguet des de sempre n'he menjats per berenar, me duu records de la infància."
                , "101.png", System.currentTimeMillis());
        insertTableBerenar(db, 102, "LLONGUET", "MIXT SERRANO",
                "LLONGUET DE CUIXOT SALAT I FORMATGE M'encanta el llonguet des de sempre n'he menjats per berenar, me duu records de la infància"
                , "102.png", System.currentTimeMillis());
        insertTableBerenar(db, 103, "PICAPICA", "PICAPICA DE POP",
                "M'encanta el pica pica de pop el trop molt gustos.",
                "103.png", System.currentTimeMillis());
        insertTableBerenar(db, 104, "LLONGUET", "SERRANITO",
                "M'encanta el llonguet des de sempre n'he menjats per berenar, me duu records de la infància",
                "104.png", System.currentTimeMillis());
        insertTableBerenar(db, 105, "LLONGUET", "MIXT SERRANO",
                "Vaig descobrir el llonguet quan vaig venir a viure a Palma i d'ençà no hi ha setmana que no menjo un Llonguet",
                "105.png", System.currentTimeMillis());
        insertTableBerenar(db, 106, "VARIAT", "COMPLET",
                "M'encanta el Variat",
                "106.png", System.currentTimeMillis());
        insertTableBerenar(db, 107, "VARIAT", "COMPLET",
                "El segon millor de Llucmajor",
                "107.png", System.currentTimeMillis());
        insertTableBerenar(db, 108, "PICAPICA", "PICAPICA DE POP",
                "M'encanta el pica pica de pop el trop molt gustos.",
                "108.png", System.currentTimeMillis());
        insertTableBerenar(db, 109, "PICAPICA", "PICAPICA DE CALAMAR",
                "M'agrada el pica pica d'aquest lloc el trop molt bo",
                "109.png", System.currentTimeMillis());



/////// 5 TAULA BAR ///////

        insertTableBar(db, 205, "Bodega Rambla", "Palma", "Via Roma, nº6");
        insertTableBar(db, 206, "Bar Rita", "Palma", "Plaça Llorenç Bisbal, 13");
        insertTableBar(db, 207, "Bar Can Felip", "Palma", "Carrer de Miquel Capllonch, 45");
        insertTableBar(db, 208, "Bar Arabic", "Llucmajor", "Carrer de la Constitució, 2");
        insertTableBar(db, 209, "Bar Colom", "Llucmajor", "Carrer de Llucmajor, 4");
/////// 3 TAULA USUARI ///////

        insertTableUsuari(db, 1, "Biel Amengual", "correubiel@gmail.com", 301);
        insertTableUsuari(db, 2, "Tomeu Capo Coll", "correuTomeu@gmail.com", 302);
        insertTableUsuari(db, 3, "Toni Oliva", "correuToni@gmail.com", 303);

/*
/////// 9 TAULA BAR BERENAR
        insertTableBarBerenar(db, 206, 101);
        insertTableBarBerenar(db, 206, 102);
        insertTableBarBerenar(db, 207, 103);
        insertTableBarBerenar(db, 206, 104);
        insertTableBarBerenar(db, 208, 105);
        insertTableBarBerenar(db, 208, 106);
        insertTableBarBerenar(db, 209, 107);
        insertTableBarBerenar(db, 207, 108);
        insertTableBarBerenar(db, 205, 109);
*/

/////// 9 TAULA USUARI BERENAR
        insertTableUsuariBerenar(db, 1, 101);
        insertTableUsuariBerenar(db, 1, 102);
        insertTableUsuariBerenar(db, 1, 103);
        insertTableUsuariBerenar(db, 2, 104);
        insertTableUsuariBerenar(db, 2, 105);
        insertTableUsuariBerenar(db, 2, 106);
        insertTableUsuariBerenar(db, 2, 107);
        insertTableUsuariBerenar(db, 3, 108);
        insertTableUsuariBerenar(db, 3, 109);


        ///////// 48 CRITERIS

        insertTableCriteri(db, 401, "CALENT",2);
        insertTableCriteri(db, 401, "PITJAT",2);
        insertTableCriteri(db, 401, "MOLLA",4);
        insertTableCriteri(db, 401, "SABOROS",3);
        insertTableCriteri(db, 401, "PRESENTACIO",3);
        insertTableCriteri(db, 402, "CALENT",2);
        insertTableCriteri(db, 402, "PITJAT",1);
        insertTableCriteri(db, 402, "MOLLA",4);
        insertTableCriteri(db, 402, "SABOROS",3);
        insertTableCriteri(db,402,"PRESENTACIO",3);
        insertTableCriteri(db,403,"PROD PRINCIPAL",2);
        insertTableCriteri(db,403,"SECUN PA",3);
        insertTableCriteri(db,403,"GENER PRINC",3);
        insertTableCriteri(db,403,"COENT",3);
        insertTableCriteri(db,403,"SABOROS",3);
        insertTableCriteri(db,403,"PRESENTACIO",1);
        insertTableCriteri(db,403,"QUANTITAT",3);
        insertTableCriteri(db,403,"PREU",2);
        insertTableCriteri(db,404,"CALENT",2);
        insertTableCriteri(db,404,"PITJAT",2);
        insertTableCriteri(db,404,"SABOROS",3);
        insertTableCriteri(db,405,"CALENT",1);
        insertTableCriteri(db,405,"PITJAT",1);
        insertTableCriteri(db,405,"SABOROS",3);
        insertTableCriteri(db,406,"QUANTITAT",1);
        insertTableCriteri(db,406,"SABOROS",3);
        insertTableCriteri(db,406,"COENT",2);
        insertTableCriteri(db,406,"PREU",1);
        insertTableCriteri(db,406,"SECUN PA",3);
        insertTableCriteri(db,407,"QUANTITAT",1);
        insertTableCriteri(db,407,"SABOROS",2);
        insertTableCriteri(db,407,"COENT",1);
        insertTableCriteri(db,407,"PREU",1);
        insertTableCriteri(db,407,"SECUN PA",3);
        insertTableCriteri(db,408,"PROD PRINCIPAL",2);
        insertTableCriteri(db,408,"SECUN PA",3);
        insertTableCriteri(db,408,"COENT",3);
        insertTableCriteri(db,408,"SABOROS",3);
        insertTableCriteri(db,408,"PRESENTACIO",1);
        insertTableCriteri(db,408,"QUANTITAT",3);
        insertTableCriteri(db,408,"PREU",2);
        insertTableCriteri(db,409,"PROD PRINCIPAL",1);
        insertTableCriteri(db,409,"SECUN PA",3);
        insertTableCriteri(db,409,"COENT",1);
        insertTableCriteri(db,409,"SABOROS",3);
        insertTableCriteri(db,409,"PRESENTACIO",2);
        insertTableCriteri(db,409,"QUANTITAT",2);
        insertTableCriteri(db,409,"PREU",2);


/////// 9 TAULA BERENAR CRITERI
        insertTableBerenarCriteri(db, 101, 401);
        insertTableBerenarCriteri(db, 102, 402);
        insertTableBerenarCriteri(db, 103, 403);
        insertTableBerenarCriteri(db, 104, 404);
        insertTableBerenarCriteri(db, 105, 405);
        insertTableBerenarCriteri(db, 106, 406);
        insertTableBerenarCriteri(db, 107, 407);
        insertTableBerenarCriteri(db, 108, 408);
        insertTableBerenarCriteri(db, 109, 409);


        /* EXEMPLES D'INSERT AMB LES PRIMARY KEY AMB LLETRES I NOMBRES
//9 BERENARS///////
// System.currentTimeMillis() és com ficarem la DATA

        insertTableBerenar(db, BE1, "LLONGUET", "SERRANITO",
                "M'encanta el llonguet des de sempre n'he menjats per berenar, me duu records de la infància.",
                "BE1.png", System.currentTimeMillis());

        insertTableBerenar(db, BE2, "LLONGUET", "MIXT SERRANO",
                "LLONGUET DE CUIXOT SALAT I FORMATGE M'encanta el llonguet des de sempre n'he menjats per berenar, me duu records de la infància",
                "BE2.png", System.currentTimeMillis());
        insertTableBerenar(db, BE3, "PICAPICA", "PICAPICA DE POP",
                "M'encanta el pica pica de pop el trop molt gustos.",
                "BE3.png", System.currentTimeMillis());
        insertTableBerenar(db, BE4, "LLONGUET", "SERRANITO",
                "M'encanta el llonguet des de sempre n'he menjats per berenar, me duu records de la infància",
                "BE4.png", System.currentTimeMillis());
        insertTableBerenar(db, BE5, "LLONGUET", "MIXT SERRANO",
                "Vaig descobrir el llonguet quan vaig venir a viure a Palma i d'ençà no hi ha setmana que no menjo un Llonguet",
                "BE5.png", System.currentTimeMillis());
        insertTableBerenar(db, BE6, "VARIAT", "COMPLET",
                "M'encanta el Variat",
                "BE6.png", System.currentTimeMillis());
        insertTableBerenar(db, BE7, "VARIAT", "COMPLET",
                "El segon millor de Llucmajor",
                "BE7.png", System.currentTimeMillis());
        insertTableBerenar(db, BE8, "PICAPICA", "PICAPICA DE POP",
                "M'encanta el pica pica de pop el trop molt gustos.",
                "BE8.png", System.currentTimeMillis());
        insertTableBerenar(db, BE9, "PICAPICA", "PICAPICA DE CALAMAR",
                "M'agrada el pica pica d'aquest lloc el trop molt bo",
                "BE9.png", System.currentTimeMillis());


/////// 9 TAULA BAR BERENAR
        insertTableBarBerenar(db, B6, BE1);
        insertTableBarBerenar(db, B6, BE2);
        insertTableBarBerenar(db, B7, BE3);
        insertTableBarBerenar(db, B6, BE4);
        insertTableBarBerenar(db, B8, BE5);
        insertTableBarBerenar(db, B8, BE6);
        insertTableBarBerenar(db, B9, BE7);
        insertTableBarBerenar(db, B7, BE8);
        insertTableBarBerenar(db, B5, BE9);


/////// 5 TAULA BAR

        insertTableBar(db, B5, "Bodega Rambla", "Palma", "Via Roma, nº6");
        insertTableBar(db, B6, "Bar Rita", "Palma", "Plaça Llorenç Bisbal, 13");
        insertTableBar(db, B7, "Bar Can Felip", "Palma", "Carrer de Miquel Capllonch, 45");
        insertTableBar(db, B8, "Bar Arabic","Llucmajor", "Carrer de la Constitució, 2");
        insertTableBar(db, B9, "Bar Colom","Llucmajor", "Carrer de Llucmajor, 4");
/////// 3 TAULA USUARI

        insertTableUsuari(db, U1, "Biel Amengual", "correubiel@gmail.com", S1);
        insertTableUsuari(db, U2, "Tomeu Capo Coll", "correuTomeu@gmail.com", S2);
        insertTableUsuari(db, U3, "Toni Oliva", "correuToni@gmail.com", S3);



/////// 9 TAULA USUARI BERENAR
        insertTableUsuariBerenar(db, U1, BE1);
        insertTableUsuariBerenar(db, U1, BE2);
        insertTableUsuariBerenar(db, U1, BE3);
        insertTableUsuariBerenar(db, U2, BE4);
        insertTableUsuariBerenar(db, U2, BE5);
        insertTableUsuariBerenar(db, U2, BE6);
        insertTableUsuariBerenar(db, U2, BE7);
        insertTableUsuariBerenar(db, U3, BE8);
        insertTableUsuariBerenar(db, U3, BE9);



/////// 9 TAULA BERENAR CRITERI
        insertTableBerenarCriteri(db, BE1, C1);
        insertTableBerenarCriteri(db, BE2, C2);
        insertTableBerenarCriteri(db, BE7, C3);
        insertTableBerenarCriteri(db, BE6, C4);
        insertTableBerenarCriteri(db, BE8, C5);
        insertTableBerenarCriteri(db, BE8, C6);
        insertTableBerenarCriteri(db, BE9, C7);
        insertTableBerenarCriteri(db, BE7, C8);
        insertTableBerenarCriteri(db, BE5, C9);



        ///////// 48 CRITERIS

        insertTableCriteri(C1,"CALENT",2);
        insertTableCriteri(C1,"PITJAT",2);
        insertTableCriteri(C1,"MOLLA",4);
        insertTableCriteri(C1,"SABOROS",3);
        insertTableCriteri(C1,"PRESENTACIO",3);
        insertTableCriteri(C2,"CALENT",2);
        insertTableCriteri(C2,"PITJAT",1);
        insertTableCriteri(C2,"MOLLA",4);
        insertTableCriteri(C2,"SABOROS",3);
        insertTableCriteri(C2,"PRESENTACIO",3);
        insertTableCriteri(C3,"PROD PRINCIPAL",2);
        insertTableCriteri(C3,"SECUN PA",3);
        insertTableCriteri(C3,"GENER PRINC",3);
        insertTableCriteri(C3,"COENT",3);
        insertTableCriteri(C3,"SABOROS",3);
        insertTableCriteri(C3,"PRESENTACIO",1);
        insertTableCriteri(C3,"QUANTITAT",3);
        insertTableCriteri(C3,"PREU",2);
        insertTableCriteri(C4,"CALENT",2);
        insertTableCriteri(C4,"PITJAT",2);
        insertTableCriteri(C4,"SABOROS",3);
        insertTableCriteri(C5,"CALENT",1);
        insertTableCriteri(C5,"PITJAT",1);
        insertTableCriteri(C5,"SABOROS",3);
        insertTableCriteri(C6,"QUANTITAT",1);
        insertTableCriteri(C6,"SABOROS",3);
        insertTableCriteri(C6,"COENT",2);
        insertTableCriteri(C6,"PREU",1);
        insertTableCriteri(C6,"SECUN PA",3);
        insertTableCriteri(C7,"QUANTITAT",1);
        insertTableCriteri(C7,"SABOROS",2);
        insertTableCriteri(C7,"COENT",1);
        insertTableCriteri(C7,"PREU",1);
        insertTableCriteri(C7,"SECUN PA",3);
        insertTableCriteri(C8,"PROD PRINCIPAL",2);
        insertTableCriteri(C8,"SECUN PA",3);
        insertTableCriteri(C8,"COENT",3);
        insertTableCriteri(C8,"SABOROS",3);
        insertTableCriteri(C8,"PRESENTACIO",1);
        insertTableCriteri(C8,"QUANTITAT",3);
        insertTableCriteri(C8,"PREU",2);
        insertTableCriteri(C9,"PROD PRINCIPAL",1);
        insertTableCriteri(C9,"SECUN PA",3);
        insertTableCriteri(C9,"COENT",1);
        insertTableCriteri(C9,"SABOROS",3);
        insertTableCriteri(C9,"PRESENTACIO",2);
        insertTableCriteri(C9,"QUANTITAT",2);
        insertTableCriteri(C9,"PREU",2);
*/


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // on upgrade drop older tables
        db.execSQL("DROP TABLE IF EXISTS " + Constants.TABLE_BERENAR);
        db.execSQL("DROP TABLE IF EXISTS " + Constants.TABLE_USUARI);
        db.execSQL("DROP TABLE IF EXISTS " + Constants.TABLE_BAR);
        db.execSQL("DROP TABLE IF EXISTS " + Constants.TABLE_SEGUIDOR);
        db.execSQL("DROP TABLE IF EXISTS " + Constants.TABLE_CRITERI);
        db.execSQL("DROP TABLE IF EXISTS " + Constants.TABLE_BAR_BERENAR);
        db.execSQL("DROP TABLE IF EXISTS " + Constants.TABLE_BERENAR_CRITERI);
        db.execSQL("DROP TABLE IF EXISTS " + Constants.TABLE_USUARI_BERENAR);


        // create new tables
        onCreate(db);
    }

    public static synchronized TablesHelper getHelper(Context context) {
        if (instance == null) {
            instance = new TablesHelper(context);
        }
        System.out.println(" TablesHelper getHelper");

        return instance;
    }

    /// Definim els metodes inserts tant dels principals com dels auxiliars. He de definir els exemples abans ben definits

//byte[] foto podria ser la foto però de moment recuperarem un String amb el seu nom
    public void insertTableBerenar(SQLiteDatabase db, int idBerenar, String tipus, String nom, String Descripcio, String foto, long date) {
        ContentValues values = new ContentValues();
        values.put(Constants.BERENAR_ID, idBerenar);
        values.put(Constants.BERENAR_TIPUS, tipus);
        values.put(Constants.BERENAR_NOM, nom);
        values.put(Constants.BERENAR_DESCRIPCIO,Descripcio);
        values.put(Constants.BERENAR_FOTO, foto);
        values.put(Constants.BERENAR_DATA, date);
        db.insert(Constants.TABLE_BERENAR, null, values);

    }

    public void insertTableBarBerenar(SQLiteDatabase db, int idBar, int idBerenar) {

        ContentValues values = new ContentValues();
        values.put(Constants.BAR_ID, idBar);
        values.put(Constants.BERENAR_ID, idBerenar);
        db.insert(Constants.TABLE_BAR_BERENAR, null, values);


    }

    public void insertTableBar(SQLiteDatabase db, int idBar, String nom, String poble, String direccio) {
        ContentValues values = new ContentValues();
        values.put(Constants.BAR_ID, idBar);
        values.put(Constants.BAR_NOM, nom);
        values.put(Constants.BAR_POBLE_CIUTAT, poble);
        values.put(Constants.BAR_DIRECCIO,direccio);
        db.insert(Constants.TABLE_BAR, null, values);

    }

    public void insertTableUsuari(SQLiteDatabase db, int idUsuari, String nom, String correu, int idSeguidor) {

        ContentValues values = new ContentValues();
        values.put(Constants.USUARI_ID, idUsuari);
        values.put(Constants.USUARI_NOM, nom);
        values.put(Constants.USUARI_CORREU, correu);
        values.put(Constants.USUARI_SEGUIDOR, idSeguidor);
        db.insert(Constants.TABLE_USUARI, null, values);
    }

    public void insertTableUsuariBerenar(SQLiteDatabase db, int idUsuari, int idBerenar) {

        ContentValues values = new ContentValues();
        values.put(Constants.USUARI_BERENAR_ID_USUARI, idUsuari);
        values.put(Constants.USUARI_BERENAR_ID_BERENAR, idBerenar);
        db.insert(Constants.TABLE_USUARI_BERENAR, null, values);

    }

    public void insertTableBerenarCriteri(SQLiteDatabase db, int idBerenar, int idCriteri) {

        ContentValues values = new ContentValues();
        values.put(Constants.BERENAR_CRITERI_ID_BERENAR, idBerenar);
        values.put(Constants.BERENAR_CRITERI_ID_CRITERI, idCriteri);
        db.insert(Constants.TABLE_BERENAR_CRITERI, null, values);

    }


    public void insertTableCriteri(SQLiteDatabase db, int idCriteri, String nom, int valor) {

        ContentValues values = new ContentValues();
        values.put(Constants.CRITERI_ID, idCriteri);
        values.put(Constants.CRITERI_NOM, nom);
        values.put(Constants.CRITERI_VALOR, valor);
        db.insert(Constants.TABLE_CRITERI, null, values);

    }


    public void insertTableSeguidor(SQLiteDatabase db, int idSeguidor, int idUsuari) {

        ContentValues values = new ContentValues();
        values.put(Constants.SEGUIDOR_ID, idSeguidor);
        values.put(Constants.SEGUIDOR_USUARI_ID, idUsuari);
        db.insert(Constants.TABLE_SEGUIDOR, null, values);

    }

}
