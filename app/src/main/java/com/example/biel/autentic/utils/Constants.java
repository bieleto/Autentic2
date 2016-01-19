package com.example.biel.autentic.utils;

/**
 * Created  on 30/12/15.
 */
public class Constants {

    // Local boolean que emprarem dins server per agafar les dades del DAO
    public static final boolean LOCAL = true;


    //Constants bbdd

    // Versió
    public static final int DATABASE_VERSION = 1;

    // Nom bbdd
    public static final String DATABASE_NAME = "autenticManager";

    // Taules
    public static final String TABLE_BERENAR = "berenar";
    public static final String TABLE_BAR = "bar";
    public static final String TABLE_CRITERI = "criteri";
    public static final String TABLE_USUARI = "usuari";
    public static final String TABLE_SEGUIDOR = "seguidor";
    public static final String TABLE_BAR_BERENAR = "bar_berenar";
    public static final String TABLE_BERENAR_CRITERI = "berenar_criteri";
    public static final String TABLE_USUARI_BERENAR = "usuari_berenar";

    // Columnes taula berenar
    public static final String BERENAR_ID = "idBerenar";
    public static final String BERENAR_TIPUS = "tipus";
    public static final String BERENAR_DESCRIPCIO = "descripció";
    public static final String BERENAR_NOM = "nom";
    public static final String BERENAR_FOTO = "foto";
    public static final String BERENAR_DATA = "data";

    // Colunmes taula bar
    public static final String BAR_ID = "idBar";
    public static final String BAR_NOM = "nom";
    public static final String BAR_DIRECCIO = "direccio";
    public static final String BAR_POBLE_CIUTAT = "poble";

    // Colunmes taula seguidor
    public static final String SEGUIDOR_ID = "idSeguidor";
    public static final String SEGUIDOR_USUARI_ID = "idUsuari";


    // Colunmes taula usuari
    public static final String USUARI_ID = "idUsuari";
    public static final String USUARI_NOM = "nom";
    public static final String USUARI_CORREU = "correu";
    public static final String USUARI_SEGUIDOR = "idSeguidor";
    // id_seguidor és poder veure tots els que ell segueix.
    // Ja pòsarem altres atributs com quan pics berena, on sol anar a berenar(zona de berenar)


    // Colunmes taula usuari_berenar
    public static final String USUARI_BERENAR_ID_USUARI = "idUsuari";
    public static final String USUARI_BERENAR_ID_BERENAR = "idBerenar";

    // Colunmes taula berenar_criteri
    public static final String BERENAR_CRITERI_ID_BERENAR = "idBerenar";
    public static final String BERENAR_CRITERI_ID_CRITERI = "idCriteri";

    // Colunmes taula criteri
    public static final String CRITERI_ID = "idCriteri";
    public static final String CRITERI_NOM = "nom";
    public static final String CRITERI_VALOR = "valor";//Normalment serà un nombre per poder calcular l'afinitat.

    // Constanstes de estado para Cental
    public static final int ESTAT_NOU = 0;
    public static final int ESTAT_SEGUIDORS = 1;
    public static final int ESTAT_APROP = 2;
    public static final int ESTAT_JO = 3;

// Exemple de com definiré els criteris dels diferents exemples per quan se mostrin a l'aplicació dins fitxa plat
    public static final String DURO = "Duro";
    public static final String BLANDO = "Blando";
    public static final String [] criteriPan = {DURO, BLANDO};



}
