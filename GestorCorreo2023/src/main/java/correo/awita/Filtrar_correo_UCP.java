package correo.awita;

import java.util.List;
import java.util.stream.Collectors;

public class Filtrar_correo_UCP {
    public static List<Correo> filtrarCorreosUCP(List<Correo> listaCorreos) {
        List<Correo> correosUniversitarios = listaCorreos.stream()
                .filter(correo -> correo.getRemitente().getMail().endsWith("@ucp.edu.ar"))
                .collect(Collectors.toList());

        return correosUniversitarios;
    }
}