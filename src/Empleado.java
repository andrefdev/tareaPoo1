import java.time.LocalDateTime;

public class Empleado extends Persona{
    private int ruc;
    private int sueldo;

    public Empleado(String nombre, LocalDateTime fechaNacimiento, String email, int telefono, String domicilio, int ruc, int sueldo) {
        super(nombre, fechaNacimiento, email, telefono, domicilio);
        this.ruc = ruc;
        this.sueldo = sueldo;
    }
    public void asignarRepartidor(int dni){

    }

}
