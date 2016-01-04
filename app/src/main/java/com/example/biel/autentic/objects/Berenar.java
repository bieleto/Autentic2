package com.example.biel.autentic.objects;

import android.media.Image;

import java.sql.Date;
import java.util.HashMap;

/**Aqui definesc els obejectes que son llegits i escrits a DAO segons la base de dades creada a TablesHelper
 * Created by biel on 31/12/15.
 */
public class Berenar {

    private int idBerenar;
    private String tipus;
    private String nom;
    private Date data;
    private Image foto;
    private String nomUsuari;
    private String nomBar;
    private String direccioBar;
    private HashMap <String, Integer> criteris;

    public int getIdBerenar() {
        return idBerenar;
    }

    public void setIdBerenar(int idBerenar) {
        this.idBerenar = idBerenar;
    }

    public String getTipus() {
        return tipus;
    }

    public void setTipus(String tipus) {
        this.tipus = tipus;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Image getFoto() {
        return foto;
    }

    public void setFoto(Image foto) {
        this.foto = foto;
    }

    public String getNomUsuari() {
        return nomUsuari;
    }

    public void setNomUsuari(String nomUsuari) {
        this.nomUsuari = nomUsuari;
    }

    public String getNomBar() {
        return nomBar;
    }

    public void setNomBar(String nomBar) {
        this.nomBar = nomBar;
    }

    public String getDireccioBar() {
        return direccioBar;
    }

    public void setDireccioBar(String direccioBar) {
        this.direccioBar = direccioBar;
    }

    public HashMap<String, Integer> getCriteris() {
        return criteris;
    }

    public void setCriteris(HashMap<String, Integer> criteris) {
        this.criteris = criteris;
    }
}
