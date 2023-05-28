import java.time.LocalDateTime;


public class Gerente extends Empleado {
    public Gerente(String nombre, LocalDateTime fechaNacimiento, String email, int telefono, String domicilio, int ruc, int sueldo) {
        super(nombre, fechaNacimiento, email, telefono, domicilio, ruc, sueldo);
    }
}
