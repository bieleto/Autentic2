package com.example.biel.autentic.model;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.biel.autentic.utils.Constants;

public class TablesHelper extends SQLiteOpenHelper {

    // Logcat tag "L'etiqueta de registre"
    private static final String LOG = "DatabaseHelper";
    private static TablesHelper instance;


    // String creació de taula  berenar
    private static final String CREATE_TABLE_BERENAR = "CREATE TABLE " + Constants.TABLE_BERENAR + "("
            + Constants.BERENAR_ID + " INTEGER PRIMARY KEY,"
            + Constants.BERENAR_TIPUS + " TEXT,"
            + Constants.BERENAR_NOM + " TEXT,"
            + Constants.BERENAR_FOTO + " BLOB,"
            + Constants.BERENAR_DATA + " DATETIME" + ")";

    // BLOB és un sistema per carregar les fotogrofaies, si ho tenguessim dins un servidor envers de blob
    // podriem posar també el link de les fotos

    // String creació taula bar_berenar
    private static final String CREATE_TABLE_BAR_BERENAR = "CREATE TABLE " + Constants.TABLE_BAR_BERENAR + "("
            + Constants.BAR_ID + " INTEGER PRIMARY KEY,"
            + Constants.BERENAR_ID + " INTEGER PRIMARY KEY" + ")";


    // String creació taula bar
    private static final String CREATE_TABLE_BAR = "CREATE TABLE " + Constants.TABLE_BAR + "("
            + Constants.BAR_ID + " INTEGER PRIMARY KEY,"
            + Constants.BAR_NOM + " TEXT,"
            + Constants.BAR_DIRECCIO + " TEXT"+ ")";


    // String creació taula seguidor
    private static final String CREATE_TABLE_SEGUIDOR = "CREATE TABLE " + Constants.TABLE_SEGUIDOR + "("
            + Constants.SEGUIDOR_ID + " INTEGER PRIMARY KEY,"
            + Constants.SEGUIDOR_USUARI_ID + " INTEGER PRIMARY KEY"+ ")";

    // String creació taula usuari
    private static final String CREATE_TABLE_USUARI = "CREATE TABLE " + Constants.TABLE_USUARI + "("
            + Constants.USUARI_ID + " INTEGER PRIMARY KEY,"
            + Constants.USUARI_NOM + " TEXT,"
            + Constants.USUARI_CORREU + " TEXT,"
            + Constants.USUARI_SEGUIDOR + " INTEGER FOREIGN KEY" + ")";


    // String creació taula usuari berenar
    private static final String CREATE_TABLE_USUARI_BERENAR = "CREATE TABLE " + Constants.TABLE_USUARI_BERENAR + "("
            + Constants.USUARI_BERENAR_ID_USUARI + " INTEGER PRIMARY KEY,"
            + Constants.USUARI_BERENAR_ID_BERENAR + " INTEGER PRIMARY KEY"+ ")";


    // String creació taula berenar criteri
    private static final String CREATE_TABLE_BERENAR_CRITERI = "CREATE TABLE " + Constants.TABLE_BERENAR_CRITERI + "("
            + Constants.BERENAR_CRITERI_ID_BERENAR + " INTEGER PRIMARY KEY,"
            + Constants.BERENAR_CRITERI_ID_CRITERI + " INTEGER PRIMARY KEY"+ ")";



    // String creació taula criteri
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
        db.execSQL(CREATE_TABLE_BAR_BERENAR);
        db.execSQL(CREATE_TABLE_SEGUIDOR);
        db.execSQL(CREATE_TABLE_USUARI);
        db.execSQL(CREATE_TABLE_BERENAR_CRITERI);
        db.execSQL(CREATE_TABLE_CRITERI);
        db.execSQL(CREATE_TABLE_BAR);
        db.execSQL(CREATE_TABLE_USUARI_BERENAR);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // on upgrade drop older tables
        db.execSQL("DROP TABLE IF EXISTS " + Constants.TABLE_BERENAR);
        db.execSQL("DROP TABLE IF EXISTS " + Constants.TABLE_BAR_BERENAR);
        db.execSQL("DROP TABLE IF EXISTS " + Constants.TABLE_USUARI_BERENAR);
        db.execSQL("DROP TABLE IF EXISTS " + Constants.TABLE_USUARI);
        db.execSQL("DROP TABLE IF EXISTS " + Constants.TABLE_BERENAR_CRITERI);
        db.execSQL("DROP TABLE IF EXISTS " + Constants.TABLE_BAR);
        db.execSQL("DROP TABLE IF EXISTS " + Constants.TABLE_SEGUIDOR);
        db.execSQL("DROP TABLE IF EXISTS " + Constants.TABLE_CRITERI);

        // create new tables
        onCreate(db);
    }

    public static synchronized TablesHelper getHelper(Context context) {
        if (instance == null) {
            instance = new TablesHelper(context);
        }
        return instance;
    }

}
