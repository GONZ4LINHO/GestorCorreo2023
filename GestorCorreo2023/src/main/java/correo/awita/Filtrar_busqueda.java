package correo.awita;
import java.util.List;
import java.util.stream.Collectors;

public class Filtrar_busqueda {
    private GestorCorreo gestor = new GestorCorreo();
    
    
    public Filtrar_busqueda() {
    }

    public Filtrar_busqueda(GestorCorreo gestor2) {
    }

    public List<Correo> buscar_correo(String criterio) {
        return gestor.getBuzonCorreo().stream()
                .filter(correo -> correo.getAsunto().contains(criterio) 
                || correo.getContenido().contains(criterio) 
                || correo.getPara().contains(criterio) 
                || correo.getRemitente().contains(criterio))
                .collect(Collectors.toList());
    }
}