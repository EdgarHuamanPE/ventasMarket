import models.Cliente;
import models.Producto;
import services.Inventario;
import services.Venta;
import utils.Parametros;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class VentasMarket {
    private Inventario inventario;
    private Scanner scanner;
    private List<Venta> ventasRealizadas;

    public VentasMarket(){
        this.inventario = new Inventario();
        this.scanner = new Scanner(System.in);
        this.ventasRealizadas = new ArrayList<>();
    }

    public void iniciar(){

        System.out.println("\n" + "=".repeat(60));
        System.out.println("    🛒 BIENVENIDO AL SISTEMA  MARKETVENTA 🛒");
        System.out.println("=".repeat(60));

        int opcion = 0;
        while (opcion != 4) {

            System.out.println("\n" + "=".repeat(50));
            System.out.println("                  MENÚ PRINCIPAL");
            System.out.println("=".repeat(50));
            System.out.println("1. 🛒 Generar Venta");
            System.out.println("2. 📊 Reporte de Ventas");
            System.out.println("4. 🚪 Salir");
            System.out.println("=".repeat(50));
            System.out.print("Seleccione una opción (1-4): ");

            try {
                opcion = Integer.parseInt(scanner.nextLine());

                switch (opcion) {
                    case 1 -> generarVenta();
                    case 2 -> mostrarReporteVentas();
                    case 4 -> {
                        System.out.println("\n🙏 ¡Gracias por usar el Sistema de MarketVenta!");
                        System.out.println("¡Vuelva pronto!");
                    }
                    default -> System.out.println("❌ Opción inválida. Por favor seleccione del 1 al 4.");
                }
            } catch (NumberFormatException e) {
                System.out.println("❌ Por favor ingrese un número válido.");
            }

            if (opcion != 4) {
                System.out.println("\nPresione ENTER para continuar...");
                scanner.nextLine();
            }
        }

    }

    private void generarVenta() {
        Venta venta = new Venta();
        boolean continuarVenta = true;

        System.out.println("\n🛍️  GENERAR NUEVA VENTA");
        System.out.println("(Escriba 'salir' para terminar la venta)");

        while (continuarVenta) {
            System.out.print("\nIngrese el nombre del producto: ");
            String nombreProducto = scanner.nextLine().trim();

            if (nombreProducto.equalsIgnoreCase("salir")) {
                continuarVenta = false;
                continue;
            }

            // Busca producto en el inventario. Trae la DB cuando instancia esta misma clase.
            if (inventario.buscarProducto(nombreProducto.toLowerCase())) {
                Producto producto = inventario.obtenerProducto(nombreProducto.toLowerCase());

                System.out.println("✓ Producto encontrado: " + producto.toString());
                System.out.print("Ingrese la cantidad: ");

                try {
                    int cantidad = Integer.parseInt(scanner.nextLine());
                    if (cantidad > 0) {
                        venta.agregarProducto(producto, cantidad);


                    } else {
                        System.out.println("❌ La cantidad debe ser mayor a 0");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("❌ Cantidad inválida");
                }
            } else {
                System.out.println("❌ Producto no encontrado");
            }
        }

        //Muestra el resumen de la venta y la guarda
        if (venta.tieneProductos()) {
            System.out.print("\nDesea Ingresar cliente:");
            String mostrarCliente = scanner.nextLine().trim();
            if (mostrarCliente.equalsIgnoreCase("si")){
                System.out.print("\n Ingresar nombre cliente:");
                String nombre = scanner.nextLine().trim();

                System.out.print("\n Ingresar apellido cliente:");
                String apellido = scanner.nextLine().trim();
                Cliente cliente=new Cliente(nombre,apellido);
                venta.setCliente(cliente);
            }else {
                Cliente cliente=new Cliente();
                venta.setCliente(cliente);
            }

            System.out.print("\n Desea Factura:");
            String tipoventa = scanner.nextLine().trim();
            if(tipoventa.equalsIgnoreCase("si")){
                venta.setIGV(Parametros.IGV);
            }

            venta.imprimirVenta();
            ventasRealizadas.add(venta);
            System.out.println("\n✅ Venta procesada exitosamente!");
        } else {
            System.out.println("\n❌ No se agregaron productos a la venta");
        }
    }

    private void mostrarReporteVentas() {
        System.out.println("\n📊 REPORTE DE VENTAS");
        System.out.println("=".repeat(50));

        if (ventasRealizadas.isEmpty()) {
            System.out.println("No se han realizado ventas aún.");
            return;
        }

        double totalVentas = 0;
        System.out.println("Total de ventas realizadas: " + ventasRealizadas.size());
        System.out.println("-".repeat(30));

        for (int i = 0; i < ventasRealizadas.size(); i++) {
            Venta venta = ventasRealizadas.get(i);
            double totalVenta = venta.calcularTotal();
            totalVentas += totalVenta;
            System.out.printf("Venta #%d: $%.2f%n", (i + 1), totalVenta);
        }

        System.out.println("-".repeat(30));
        System.out.printf("TOTAL GENERAL: $%.2f%n", totalVentas);
        System.out.printf("PROMEDIO POR VENTA: $%.2f%n",
                ventasRealizadas.isEmpty() ? 0 : totalVentas / ventasRealizadas.size());
    }

    public static void main(String[] args) {

        VentasMarket market = new VentasMarket();
        market.iniciar();
    }
}
