import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.junit.Before;
import org.junit.Test;
import correo.awita.*;

public class Correo_Test{
    
    @Test
    public void Enviar_correo_test(){
        Contacto persona1 = new Contacto("Juan", "Perez", "juan@gmail.com");
        persona1.getNombre();
        persona1.getApellido();
        persona1.getMail();
        
        String persona2 = "javiermilei@ucp.edu.ar";
        

        Correo correo = new Correo("Prueba UCP","Paradigmas 2" , persona1, List.of(persona2));
        assertEquals("Prueba UCP", correo.getAsunto());
        assertEquals("Paradigmas 2", correo.getContenido());
        assertEquals(persona1, correo.getRemitente());
        assertEquals(List.of(persona2), correo.getPara()); 
    }

    @Test
    public void Enviar_correo_varios_usuarios_test(){
        //Creo un remitente quien mandara el correo
        Contacto remi = new Contacto("Juan", "Perez", "juan@gmail.com");
        remi.getNombre();
        remi.getApellido();
        remi.getMail();

        List<String> paras = new ArrayList<>();
        for (int i=0; i<1000; i++){
            paras.add("receptor"+i+"@gmail.com");//Creo varios usuarios terminados en @gmail
        }
        for(String para : paras){
        Correo correo = new Correo("Prueba UCP", "Milei Presidente 2023", remi, List.of(para));
            assertEquals("Prueba UCP", correo.getAsunto());
            assertEquals("Milei Presidente 2023", correo.getContenido());
            assertEquals(remi, correo.getRemitente());
            assertEquals(List.of(para), correo.getPara());
        }
    }    
    @Test
    public void validarCorreo_valido_Test() {
        
        Contacto contacto = new Contacto("Juan", "Perez", "jose@ucp.edu.ar");

        boolean resultado = Validacion_Mail.validar_correo(contacto);

        assertTrue(resultado);
    }

    @Test
    public void validarCorreo_invalido_Test() {

        Contacto contacto = new Contacto("Maria", "Gomez", "gm");

        boolean resultado = Validacion_Mail.validar_correo(contacto);

        assertFalse(resultado);
    }

    @Test //Test de filtro UCP
    public void testFiltrarCorreosUCP() {
        Contacto contactoUCP1 = new Contacto("Jose", "Fernandez", "jose@ucp.edu.ar");
        Contacto contactoUCP2 = new Contacto("Jose", "Fernandez", "mauri@ucp.edu.ar");
        Contacto contactoNoUCP = new Contacto("Jose", "Fernandez", "pepe@hotmail");

        Correo correo1 = new Correo("Asunto1", "Contenido1", contactoUCP1, new ArrayList<String>());
        Correo correo2 = new Correo("Asunto2", "Contenido2", contactoUCP2, new ArrayList<String>());
        Correo correo3 = new Correo("Asunto3", "Contenido3", contactoNoUCP, new ArrayList<String>());

        List<Correo> listaCorreos = new ArrayList<>();
        listaCorreos.add(correo1);
        listaCorreos.add(correo2);
        listaCorreos.add(correo3);

        List<Correo> correosFiltrados = Filtrar_correo_UCP.filtrarCorreosUCP(listaCorreos);

        assertEquals(2, correosFiltrados.size());
        assertTrue(correosFiltrados.contains(correo1));
        assertTrue(correosFiltrados.contains(correo2));
        assertFalse(correosFiltrados.contains(correo3));
    }

    @Test
    public void buscar_correo_devuelve_una_lista_vacia_si_el_criterio_es_nulo_o_vacio() {
        Buzon buzon = new Buzon();
        GestorCorreo gestor = new GestorCorreo(buzon);
        Filtrar_busqueda filtrar_busqueda = new Filtrar_busqueda(gestor);

        List<Correo> correosFiltrados = filtrar_busqueda.buscar_correo(null);
        assertEquals(0, correosFiltrados.size());

        correosFiltrados = filtrar_busqueda.buscar_correo("");
        assertEquals(0, correosFiltrados.size());
    }

    @Test
    public void testFiltrarRemitentesPorAsunto() {
        List<Correo> listaCorreos = new ArrayList<>();
        Contacto remitente1 = new Contacto("Nombre1", "Apellido1", "correo1@ejemplo.com");
        Contacto remitente2 = new Contacto("Nombre2", "Apellido2", "correo2@ejemplo.com");
        Contacto remitente3 = new Contacto("Nombre3", "Apellido3", "correo3@ejemplo.com");

        Correo correo1 = new Correo("Asunto importante", "Contenido1", remitente1, null);
        Correo correo2 = new Correo("Asunto irrelevante", "Contenido2", remitente2, null);
        Correo correo3 = new Correo("Asunto importante", "Contenido3", remitente3, null);

        listaCorreos.add(correo1);
        listaCorreos.add(correo2);
        listaCorreos.add(correo3);

        String asuntoBuscado = "Asunto importante";

        List<Contacto> remitentesFiltrados = Filtro_remitenteAsunto.filtrarRemitentesPorAsunto(listaCorreos, asuntoBuscado);

        assertEquals(2, remitentesFiltrados.size());
        assertTrue(remitentesFiltrados.contains(remitente1));
        assertTrue(remitentesFiltrados.contains(remitente3));
        assertFalse(remitentesFiltrados.contains(remitente2));
    }

    @Test
    public void testFiltrarCorreosPorMensajeAsunto() {
        List<Correo> listaCorreos = new ArrayList<>();

        Correo correo1 = new Correo("Asunto importante", "Contenido relevante", null, null);
        Correo correo2 = new Correo("Asunto importante", "Contenido irrelevante", null, null);

        listaCorreos.add(correo1);
        listaCorreos.add(correo2);

        String asuntoBuscado = "Asunto importante";
        String contenidoBuscado = "Contenido relevante";

        List<Correo> correosFiltrados = Filtro_MensajeAsunto.filtrarCorreosPorMensajeAsunto(listaCorreos, asuntoBuscado, contenidoBuscado);

        assertEquals(1, correosFiltrados.size());
        assertTrue(correosFiltrados.contains(correo1));
        assertFalse(correosFiltrados.contains(correo2));
    }
} 