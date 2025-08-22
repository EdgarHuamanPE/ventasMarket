package models;

public class Cliente extends Persona{

    private String correo;
    private String telefono;
    private String fullname;

    public Cliente(int dni, String nombre, String apellidoPat, String apellidoMat,String correo,String telefono) {
        super(dni, nombre, apellidoPat, apellidoMat);
        this.correo= correo;
        this.telefono=telefono;
        this.fullname=nombre.substring(0,1) +" "+ apellidoPat +" "+ apellidoMat;
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
