package com.ues.edu.sv.ipam.crudipam.sqlLite;

import java.io.Serializable;

/**
 * Created by Carlos Carlos Ruano.
 */
public class Contactos implements Serializable {

    private static final long serialVersionUID = 1L;


    private int ID;
    private String nombre;
    private String telefono;
    private String apellido;
    private String correo;
    private String edad;
    private String domicilio;

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public int getID() {
        return ID;
    }

    public void setID(int iD) {
        ID = iD;
    }

    public Contactos() {
        super();

    }

    public Contactos(String nombre, String telefono) {
        super();
        this.nombre = nombre;
        this.telefono = telefono;
    }

    public Contactos(int id, String nombre, String telefono) {
        super();
        this.ID = id;
        this.nombre = nombre;
        this.telefono = telefono;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getTelefono() {
        return telefono;
    }
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

}
