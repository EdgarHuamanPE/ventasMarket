package contracts;
import models.Producto;

public interface IInventario {
    public void agregarProducto(Producto producto);
    public boolean buscarProducto(String nombre);
    public Producto obtenerProducto(String nombre);
    public void imprimirInventario();
}