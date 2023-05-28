import javax.swing.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/*
Una heladería desea abrir un nuevo punto de venta a través de Internet. Para ello, necesita desarrollar un sistema que le permita automatizar el proceso de pedido y delivery. Cuando un cliente ingrese a la página del sitio de la heladería deberá:
• Poder consultar los sabores de helado disponibles (con stock) y su composición.
• Realizar pedidos (especificando cantidad y sabores de sus helados).
• Cuando el cliente realice un pedido obtendrá de inmediato un código de pedido.
• Si no es un usuario registrado, deberá ingresar previamente sus datos especificando nombre, domicilio, teléfono, e-mail, fecha de nacimiento.
• Verificar el estado de su pedido.
Los empleados de planta son quienes se encargan de armar los pedidos y asignarlos a un repartidor. Una vez armado el pedido y entregado a un repartidor, ingresa en el sistema el código de repartidor y horario del pedido (hora de salida de pedido).
El gerente necesita que el sistema le permita obtener la cantidad de pedidos y la cantidad de kilos de helado que se solicitan por día.
Los datos que se guardan del repartidor son: número de repartidor, nombre y domicilio.
 */
public class Main {
    static Almacen almacen = new Almacen();
    public static void main(String[] args) {
        almacen.anadirProducto(0, 5,10, "Vainilla", 1, "Queso");
        RegistoPersonas registoPersonas = new RegistoPersonas();
        String menuLoginRegistro = "Seleccione una opcion: \n" +
                "1. Login \n" +
                "2. Registrarse \n" +
                "9. Salir";

        String nombre = null;
        LocalDateTime fechaNacimiento = null;
        String email = null;
        int telefono = 0;
        String domicilio = null;

        int opcionLogin = 0;
        while (opcionLogin != 9){
            opcionLogin = Integer.parseInt(JOptionPane.showInputDialog(menuLoginRegistro));
            switch (opcionLogin) {
                case 1:
                    email = JOptionPane.showInputDialog("Ingrese su correo");
                    Cliente cliente = registoPersonas.buscarClientes(email);
                    if (cliente == null){
                        System.out.println("ingreso incorrecto");
                    }
                    else {
                        //almacen.gestionarPedido(cliente);
                        //cliente.realizarPedido();
                        menuClienteLogueado(cliente);
                    }
                    break;
                case 2:
                    // Registro cliente
                    nombre = JOptionPane.showInputDialog("Ingrese su nombre");
                    fechaNacimiento = escribirFecha();
                    telefono = Integer.parseInt(JOptionPane.showInputDialog("Ingrese su teléfono"));
                    domicilio = JOptionPane.showInputDialog("Ingrese su domicilio");
                    email = JOptionPane.showInputDialog("Ingrese su correo");
                    registoPersonas.registrarClientes(nombre,fechaNacimiento,email,telefono,domicilio);
                    System.out.println(registoPersonas.getClientes().get(0).getNombre().toString());
                    break;
                case 9:
                    // Salir del programa
                    System.exit(0);
                    break;
            }
        }
    }
    public static void menuClienteLogueado(Cliente cliente){

        String menu = "Seleccione una opcion: \n" +
                "1. Catalogo \n" +
                "2. Pagar \n" +
                "9. Salir \n";

        int opcion = 0;
        while (opcion != 9){
            opcion = Integer.parseInt(JOptionPane.showInputDialog(menu));
            switch (opcion) {
                case 1:
                    JOptionPane.showMessageDialog(null, almacen.mostrarHelados());
                    break;
                case 2:
                    int tipoHelado = Integer.parseInt(JOptionPane.showInputDialog(almacen.mostrarHelados()));
                    int cantidad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de helados que desea:"));
                    cliente.realizarPedido(almacen, tipoHelado, cantidad);
                    break;
                case 3:
                    break;
            }
        }
    }

    public static void menuGerenteLogueado(Cliente cliente){
        String menu = "Seleccione una opcion: \n" +
                "1. Agregar un producto \n" +
                "2. Actualizar el stcok \n" +
                "3. Eliminar un producto \n" +
                "9. Salir \n";

        int opcion = 0;
        while (opcion != 9){
            opcion = Integer.parseInt(JOptionPane.showInputDialog(menu));
            switch (opcion) {
                case 1:
                    int indice = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el indice"));
                    String tipo = JOptionPane.showInputDialog("Ingrese el tipo");
                    int precio = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el precio"));
                    int cantidad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad"));
                    int codigo = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad"));
                    String composicion = JOptionPane.showInputDialog("Ingrese la composicion");
                    almacen.anadirProducto(cantidad, cantidad,precio, tipo, codigo, composicion);
                    break;
                case 2:
                    int tipoHelado = Integer.parseInt(JOptionPane.showInputDialog(almacen.mostrarHelados()));
                    int cantidad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de helados que desea:"));
                    cliente.realizarPedido(almacen, tipoHelado, cantidad);
                    break;
                case 3:
                    break;
            }
        }
    }

    public static LocalDateTime escribirFecha(){
        LocalDateTime fechaNacimiento = null;
        String input = JOptionPane.showInputDialog("Ingrese la fecha (formato: dd/MM/yyyy)");
        String fechaCompleta = input + " 00:00:00";
        // Crear un formateador de fecha
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        try {
            // Parsear la fecha ingresada en un objeto LocalDateTime
            fechaNacimiento = LocalDateTime.parse(fechaCompleta, formatter);
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, "Formato de fecha inválido");
            escribirFecha();
        }
        return fechaNacimiento;
    }
}

