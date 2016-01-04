package com.example.biel.autentic.objects;



/**Aqui definesc els obejectes que son llegits i escrits a DAO segons la base de dades creada a TablesHelper
 * Created by biel on 31/12/15.
 */
public class Bar {

    private int idBar;
    private String direccioBar;
    private String nombre;

    public int getIdBar() {
        return idBar;
    }

    public void setIdBar(int idBar) {
        this.idBar = idBar;
    }

    public String getDireccioBar() {
        return direccioBar;
    }

    public void setDireccioBar(String direccioBar) {
        this.direccioBar = direccioBar;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
