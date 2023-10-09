import org.junit.Before;
import org.junit.Test;

import correo.awita.Buzon;
import correo.awita.Contacto;
import correo.awita.Correo;

import static org.junit.Assert.*;

import java.util.List;

public class Buzon_Test {
    Buzon buzon;

    @Before
    public void setUp() {
        buzon = new Buzon();
    }

    @Test
    public void recibirCorreoTest() {
        Correo correo = new Correo("Asunto 1", "Contenido 1", new Contacto("Juan", "Perez", "juan@gmail.com"), List.of("destinatario@example.com"));
        buzon.recibirCorreo(correo);

        // Verificar que el correo ha sido recibido en el buzon
        assertEquals(1, buzon.getCorreosRecibidos().size());
    }

    @Test
    public void enviarCorreoTest() {
        Correo correo = new Correo("Asunto 2", "Contenido 2", new Contacto("Ana", "Lopez", "ana@gmail.com"), List.of("destinatario@example.com"));
        buzon.enviarCorreo(correo);

        // Verificar que el correo ha sido enviado desde el buzon
        assertEquals(1, buzon.getCorreosEnviados().size());
    }

    @Test
    public void buzonInicialmenteVacioTest() {
        // Verificar que ambos buzones estén inicialmente vacíos
        assertNotNull(buzon.getCorreosRecibidos());
        assertNotNull(buzon.getCorreosEnviados());
        assertEquals(0, buzon.getCorreosRecibidos().size());
        assertEquals(0, buzon.getCorreosEnviados().size());
    }
}