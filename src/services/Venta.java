package services;
import  contracts.IVenta;
import models.Cliente;
import models.DetalleVenta;
import models.Persona;
import models.Producto;
import utils.StringUtils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Venta implements  IVenta {
    private List<DetalleVenta> detalleV;
    private double total;
    private LocalDateTime fecha;
    private int serieVenta;
    private double IGV;
    private Cliente cliente;
    public static int iteradorVenta=1;


    public Venta(){
        detalleV= new ArrayList<>();
        fecha = LocalDateTime.now();
        serieVenta=iteradorVenta++;
        this.IGV=0;
    }

    public double getIGV() {
        return IGV;
    }

    public void setIGV(double IGV) {
        this.IGV = IGV;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @Override
    public void agregarProducto(Producto producto, int cantidad){
        if (producto.getStock() >= cantidad) {
            DetalleVenta detalle = new DetalleVenta(producto, cantidad);
            detalleV.add(detalle);
            // Actualizar el stock del producto
            producto.setStock(producto.getStock() - cantidad);
        } else {
            System.out.println("❌ Error: Stock insuficiente. Stock disponible: " + producto.getStock());
        }
    }

    @Override
    public double calcularTotal() {
        return detalleV
                .stream()
                .mapToDouble(DetalleVenta::getSubtotal)
                .sum();
    }

    @Override
    public void imprimirVenta() {
        System.out.println("\n" + "=".repeat(60));
        System.out.println(" ".repeat(20)+"BOLETA DE VENTA #" + serieVenta);
        System.out.println("=".repeat(60));
        System.out.println("Fecha: " + fecha.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"))
                + " ".repeat(15)+"Cliente:" + cliente.getFullname());
        System.out.println("-".repeat(60));

        for (DetalleVenta detalleVenta : detalleV) {
            detalleVenta.imprimeDetalleVenta();
        }

        System.out.println("-".repeat(60));
        System.out.printf("IGV: S/%.2f%n", calcularTotal()*IGV/100);
        System.out.printf("TOTAL: S/%.2f%n", calcularTotal()*(IGV+100)/100);
        System.out.println("=".repeat(60));
    }

    public boolean tieneProductos() {
        return !detalleV.isEmpty();
    }

}
