package com.example.biel.autentic.model;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import com.example.biel.autentic.objects.Usuari;
import com.example.biel.autentic.utils.Constants;
import com.example.biel.autentic.model.TablesHelper;

import java.sql.SQLException;

/**
 *
 *
 * Created by biel on 30/12/15.
 */
public class UsuariDAO {

    protected SQLiteDatabase database;
    private TablesHelper tablesHelper;
    private Context context;



    public UsuariDAO (Context context) {
        this.context = context;
        tablesHelper = TablesHelper.getHelper(context);
      //  open();

    }

    public void open() throws SQLException {
        if(tablesHelper == null) {
            tablesHelper = TablesHelper.getHelper(context);
        }
        database = tablesHelper.getWritableDatabase();
    }

    public boolean createUsuari(Usuari usuari) {

        ContentValues values = new ContentValues();
        values.put(Constants.USUARI_ID, usuari.getIdUsuari());


        database.insert(Constants.TABLE_USUARI, null, values);

        return true;

    }

    public boolean deleteUsuari(int idUsuari) {

        return true;
    }

    public boolean updateUsuari(int idUsuari) {

        return true;
    }


    public Usuari getUsuari(int idUsuari) {

        return null;
    }


}
