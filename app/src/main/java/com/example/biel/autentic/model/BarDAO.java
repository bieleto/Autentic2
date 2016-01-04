package com.example.biel.autentic.model;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.biel.autentic.objects.Bar;
import com.example.biel.autentic.utils.Constants;

import java.sql.SQLException;

/**
 * Created by biel on 30/12/15.
 */
public class BarDAO {
    protected SQLiteDatabase database;
    private TablesHelper tablesHelper;
    private Context context;
    public BarDAO (Context context){
        this.context = context;
        tablesHelper = TablesHelper.getHelper(context);
        open();
    }
    //Definesc el procediment open emprat més amunt
    public void open() throws SQLException {
        if (tablesHelper == null){
            tablesHelper = TablesHelper.getHelper(context);
        }
        database = tablesHelper.getWritableDatabase();
    }

    public boolean createBar (Bar bar){
        ContentValues values = new ContentValues();
        values.put(Constants.BAR_ID, bar.getIdBar());

        database.insert(Constants.TABLE_BAR, null, values);
        return true;
    }

    public boolean deleteBar(int idBar) {

        return true;
    }

    public boolean updateBar(int idBar) {

        return true;
    }


    public Bar getBar(int idBar) {

        return null;

    }






}
