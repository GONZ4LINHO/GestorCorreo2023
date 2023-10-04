package correo.awita;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class filtros {
    protected GestorCorreo gestor = new GestorCorreo();
    
    
    public List<Correo> buscar_correo(String criterio) {
        return gestor.getBuzonCorreo().stream()
                .filter(correo -> correo.getAsunto().contains(criterio) || correo.getContenido().contains(criterio) || correo.getPara().contains(criterio) || correo.getRemitente().contains(criterio))
                .collect(Collectors.toList());
    }

    protected List<Buzon> buzones = new ArrayList<>();
    
    public List<Buzon> buscar_buzon(String criterio) {
        // Filtrar correos enviados
        List<Correo> correosEnviados = gestor.getBuzonCorreo().stream()
                .filter(correo -> correo.getRemitente().contains(criterio)) // Reemplaza con el nombre del remitente deseado
                .collect(Collectors.toList());

        // Filtrar correos recibidos
        List<Correo> correosRecibidos = gestor.getBuzonCorreo().stream()
                .filter(correo -> correo.getPara().contains(criterio)) // Reemplaza con el nombre del destinatario deseado
                .collect(Collectors.toList());

        

        return buzones;
    }
    
}

