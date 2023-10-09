import static org.junit.Assert.*;
import org.junit.Test;
import correo.awita.*;

public class Contacto_Test {
    @Test 
    public void datos_test(){
        Contacto persona1 = new Contacto("Roberto", "Perez", "gomezroberto@gmail.com");
        assertNotNull(persona1);
        assertNotNull(persona1.getNombre());
        assertNotNull(persona1.getMail());
        assertNotNull(persona1.getApellido());
    }

    @Test (expected = NullPointerException.class)
    public void dato_nulo_test(){
        Contacto p1 =new Contacto(null, null, "gomezroberto@gmail.com");
        
        assertNotNull(p1);
        
        if(p1.getNombre()== null || p1.getApellido()==null || p1.getMail()==null){
            p1.getNombre();
            p1.getApellido();
            p1.getMail();
            throw new NullPointerException("Persona1 posee datos nulos");
        }
    } 
}