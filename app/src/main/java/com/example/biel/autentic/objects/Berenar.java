package com.example.biel.autentic.objects;

import android.media.Image;

import java.sql.Blob;
import java.sql.Date;
import java.util.HashMap;

/**Aqui definesc els obejectes que son llegits i escrits a DAO segons la base de dades creada a TablesHelper
 * Created by biel on 31/12/15.
 * Aquí tenim més atributs que en tableshelper pq volem estuviar espai en la taula (https://es.wikipedia.org/wiki/Normalizaci%C3%B3n_de_bases_de_datos)
 * Sí per exemple ficam 20 berenars d'un usuari en un bar  lo que intentam es no repetir 20 pics el nom i direcció bar
 *
 */
public class Berenar {

    private int idBerenar;
    private String tipus;
    private String nom;
    private String descripcio;
    private Long data;//És long envers de Date per evitar problemes. Després a l'hora de visualitzar o convertirem
    private String foto;// Envers de image o blob millor ara posam String pq pensam que ens anirà millor també canviam el get i set
    private String nomUsuari;
    private String nomBar;
    private String direccioBar;
    private HashMap <String, Integer> criteris;
    //el nombre de pics és un atribut per identificar que aquest berenar és un berenar sovint per l'usuari autèntic.
    //L'idea principal seria que posi el nombre de pics que hi va per setmana o deixar-ho en null mentres no sigui un berenar fitxe que hi vagi esporàdicament.
    private int picspersetmana;

    public void setDescripcio(String descripcio) {
        this.descripcio = descripcio;
    }

    public String getDescripcio() {

        return descripcio;
    }

    public int getPicspersetmana() {
        return picspersetmana;
    }

    public void setPicspersetmana(int picspersetmana) {
        this.picspersetmana = picspersetmana;
    }

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

    public Long getData() {
        return data;
    }

    public void setData(Long data) {
        this.data = data;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
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
