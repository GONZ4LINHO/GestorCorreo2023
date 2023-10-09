package correo.awita;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Filtro_remitenteAsunto {
    public static List<Contacto> filtrarRemitentesPorAsunto(List<Correo> listaCorreos, String asunto) {
        // Define un Predicate personalizado para verificar si el asunto es igual
        Predicate<Correo> asuntoIgual = correo -> correo.getAsunto().equalsIgnoreCase(asunto);

        List<Contacto> remitentesFiltrados = listaCorreos.stream()
                .filter(asuntoIgual) // Aplica el Predicate personalizado
                .map(Correo::getRemitente) // Toma al remitente del correo
                .distinct() // Elimina remitentes duplicados
                .collect(Collectors.toList());

        return remitentesFiltrados;
    }
}
