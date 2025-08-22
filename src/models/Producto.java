package models;

public class Producto {

    //Encapsulamiento de clase producto

    private String nombre;
    private double precio;
    private int stock;
    private String categoria;
    private String codigo;

    public Producto(){};

    public Producto(String nombre, double precio, int stock, String categoria,String codigo){
        this.nombre=nombre;
        this.precio=precio;
        this.stock=stock;
        this.categoria=categoria;
        this.codigo=codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void imprimirProducto(){
        System.out.printf("%-15s %-10s $%-8.2f Stock: %-5d Categoría: %s%n",
                nombre, codigo, precio, stock, categoria);
    }
}
