package com.example.biel.autentic.objects;



/**Aqui definesc els obejectes que son llegits i escrits a DAO segons la base de dades creada a TablesHelper
 * Created by biel on 31/12/15.
 */
public class Usuari {

    private int idUsuari;
    private String correu;
    private String nom;
    private int IdUsuariSeguidor;

    public int getIdUsuari() {
        return idUsuari;
    }

    public String getCorreu() {
        return correu;
    }

    public int getIdUsuariSeguidor() {
        return IdUsuariSeguidor;
    }

    public String getNom() {
        return nom;
    }

    public void setIdUsuari(int idUsuari) {
        this.idUsuari = idUsuari;
    }

    public void setCorreu(String correu) {
        this.correu = correu;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setIdUsuariSeguidor(int idUsuariSeguidor) {
        IdUsuariSeguidor = idUsuariSeguidor;
    }
}
