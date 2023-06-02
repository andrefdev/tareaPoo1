import java.time.LocalDateTime;
import java.util.*;

public class RegistoPersonas {

    Hashtable<Integer, Persona> personas = new Hashtable<Integer, Persona>();

    public Persona buscarPersona(int dni){
        return personas.get(dni);
    }

    public void registrarPersona(Persona persona){
        personas.put(persona.getDni(), persona);
    }

    public String obtenerDatosDePersonas(){
        Persona p;
        String dx="";
        Enumeration<Persona> enu = personas.elements();
        while(enu.hasMoreElements()){
            p=enu.nextElement();
            dx=dx+p.toString()+"\n";
        }
        return dx;
    }
}
