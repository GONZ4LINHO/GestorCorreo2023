import static org.junit.Assert.*;
import static org.junit.Assume.assumeTrue;

import java.util.concurrent.TimeUnit;

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
    
}
