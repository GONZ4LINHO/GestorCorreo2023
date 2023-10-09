package correo.awita;

import java.util.ArrayList;
import java.util.List;

public class GestorCorreo {
    public List<Correo> buzonCorreo;

    public GestorCorreo() {
        this.buzonCorreo = new ArrayList<>();
        
    }

    public GestorCorreo(Buzon buzon) {
    }

    public void crear_correo(String asunto, String contenido, Contacto remitente, List<String> para) {
        Correo nuevoCorreo = new Correo(asunto, contenido, remitente, para);
        buzonCorreo.add(nuevoCorreo);

    }
    public List<Correo> getBuzonCorreo() {
        return buzonCorreo;
    }
    
}
