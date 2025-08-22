package contracts;

import models.Producto;

public interface IVenta {
    public void agregarProducto(Producto producto, int cantidad);
    public double calcularTotal();
    public void imprimirVenta();
}