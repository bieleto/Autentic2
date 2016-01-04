package com.example.biel.autentic.model;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.biel.autentic.objects.Berenar;
import com.example.biel.autentic.utils.Constants;

import java.sql.SQLException;

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
        open();

    }

    public void open() throws SQLException {
        if(tablesHelper == null) {
            tablesHelper = TablesHelper.getHelper(context);
        }
        database = tablesHelper.getWritableDatabase();
    }

    public boolean createBerenar(Berenar berenar) {

        ContentValues values = new ContentValues();
        values.put(Constants.BERENAR_ID, berenar.getIdBerenar());


        database.insert(Constants.TABLE_BERENAR, null, values);

        return true;

    }

    public boolean deleteBerenar(int idBerenar) {

        return true;
    }

    public boolean updateBerenar(int idBerenar) {

        return true;
    }


        public Berenar getBerenar(int idBerenar) {

            return null;
    }
}
