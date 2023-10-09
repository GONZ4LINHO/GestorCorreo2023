import static org.junit.Assert.assertEquals;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import correo.awita.*;

public class Gestor_test {
    @Test
    public void crearCorreo_AgregarCorreo_CorreoEnBuzon() {
        GestorCorreo gestorCorreo = new GestorCorreo();
        
        Contacto remitente = new Contacto("Juan", "Perez", "juan@gmail.com");
        List<String> para = new ArrayList<>();
        para.add("persona1@gmail.com");

        gestorCorreo.crear_correo("Prueba UCP", "Paradigmas 2", remitente, para);
        
        List<Correo> buzonCorreo = gestorCorreo.getBuzonCorreo();
        assertEquals(1, buzonCorreo.size());
        Correo correo = buzonCorreo.get(0);
        assertEquals("Prueba UCP", correo.getAsunto());
        assertEquals("Paradigmas 2", correo.getContenido());
        assertEquals(remitente, correo.getRemitente());
        assertEquals(para, correo.getPara());
    }
}