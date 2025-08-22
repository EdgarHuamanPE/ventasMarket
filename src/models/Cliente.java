package models;

import utils.StringUtils;

public class Cliente extends Persona{

    private String correo;
    private String telefono;
    private String fullname;


    public Cliente(){
        this(0,"default","default","default","default","default");
    }

    public Cliente(String nombre,String apellidoPat){
        this(0,nombre,apellidoPat,"default","default","default");
    }

    public Cliente(int dni, String nombre, String apellidoPat, String apellidoMat, String correo, String telefono) {
        super(dni, nombre, apellidoPat, apellidoMat);
        this.correo= correo;
        this.telefono=telefono;
        this.fullname= StringUtils.capitalizar(nombre,apellidoPat);

    }

    public String getFullname() {
        return fullname;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void mostrarCliente(){
        System.out.printf("DNI:%-10d %-10s %-10s %-10s %-20s %-10s",
                   dni,nombre, apellidoPat, apellidoMat,correo,telefono);
    }
}
