package correo.awita;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Filtro_MensajeAsunto {
    public static List<Correo> filtrarCorreosPorMensajeAsunto(List<Correo> listaCorreos, String asunto, String contenido) {
        // Define un Predicate personalizado que verifica si el asunto y el contenido coinciden
        Predicate<Correo> criterioMensajeAsunto = correo -> {
            boolean condicion1 = correo.getAsunto().toLowerCase().contains(asunto.toLowerCase());
            boolean condicion2 = correo.getContenido().toLowerCase().contains(contenido.toLowerCase());
            return condicion1 && condicion2;
        };

        List<Correo> correosFiltrados = listaCorreos.stream()
                .filter(criterioMensajeAsunto) // Aplica el Predicate personalizado
                .collect(Collectors.toList());

        return correosFiltrados;
    }
}