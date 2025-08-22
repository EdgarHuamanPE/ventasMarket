import models.Cliente;
import models.DetalleVenta;
import models.Persona;
import models.Producto;
import services.Venta;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
           // to see how IntelliJ IDEA suggests fixing it.
        Producto p = new Producto("Leche",20.1,12,"lacteos","ac");

        Venta v = new Venta();

        v.agregarProducto(p,10);
        v.setIGV(18);
        Cliente c = new Cliente(44319960,"edgar","Huaman","Pumachapi","rhum.sap@gmail.com","972200095");
        v.setCliente(c);
        v.imprimirVenta();
        //c.mostrarCliente();


        }
    }
