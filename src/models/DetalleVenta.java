package models;

public class DetalleVenta {
    private Producto producto;
    private int cantidad;
    private double subtotal;

    public DetalleVenta(Producto producto, int cantidad){
        this.producto=producto;
        this.cantidad=cantidad;
        subtotal=producto.getPrecio()*cantidad;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public void imprimeDetalleVenta(){
        System.out.printf("%-20s %-3d UND S/%-8.2f = S/%-10.2f%n",
                producto.getNombre(), cantidad,
                producto.getPrecio(), subtotal);
    }
}
