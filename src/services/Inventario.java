package services;

import models.Producto;

import java.util.HashMap;
import java.util.Map;
import  contracts.IInventario;

public class Inventario implements IInventario{

     private Map<String, Producto> productos;

     public Inventario(){
         this.productos= new HashMap<>();
         iniciarBaseDatosProductos();
     }

    private void iniciarBaseDatosProductos() {
        agregarProducto(new Producto("pilsen", 7.0, 100, "Cervezas", "CE001"));
        agregarProducto(new Producto("cristal", 7.0, 100, "Cervezas", "CE002"));
        agregarProducto(new Producto("jhony walker rojo", 55.0, 50, "Wiski", "WI001"));
        agregarProducto(new Producto("old Time rojo", 23, 50, "Wiski", "WI002"));
}

    @Override
    public void agregarProducto(Producto producto) {
        productos.put(producto.getNombre(), producto);
    }

    @Override
    public  boolean buscarProducto(String nombre) {
         return productos.containsKey(nombre);
    }

    @Override
    public Producto obtenerProducto(String nombre) {
        return productos.get(nombre);
    }

    @Override
    public void imprimirInventario() {
        System.out.println("\n" + "=".repeat(70));
        System.out.println("                    INVENTARIO DE PRODUCTOS");
        System.out.println("=".repeat(70));
        System.out.printf("%-15s %-10s %-10s %-8s %-12s%n",
                "PRODUCTO", "CÓDIGO", "PRECIO", "STOCK", "CATEGORÍA");
        System.out.println("-".repeat(70));

        productos.values().stream()
                .sorted((p1, p2) -> p1.getCategoria().compareTo(p2.getCategoria()))
                .forEach(Producto::imprimirProducto);

        System.out.println("=".repeat(70));
    }
}
