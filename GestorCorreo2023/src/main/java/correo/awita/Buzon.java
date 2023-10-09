package correo.awita;

import java.util.ArrayList;
import java.util.List;

public class Buzon {
    private List<Correo> correosRecibidos;
    private List<Correo> correosEnviados;

    public Buzon() {
        correosRecibidos = new ArrayList<>();
        correosEnviados = new ArrayList<>();
    }

    public List<Correo> getCorreosRecibidos() {
        return correosRecibidos;
    }

    public List<Correo> getCorreosEnviados() {
        return correosEnviados;
    }

    public void recibirCorreo(Correo correo) {
        correosRecibidos.add(correo);
    }

    public void enviarCorreo(Correo correo) {
        correosEnviados.add(correo);
    }

    public List<Correo> getBuzonCorreo() {
        List<Correo> buzonCorreo = new ArrayList<>();
        buzonCorreo.addAll(correosRecibidos);
        buzonCorreo.addAll(correosEnviados);
        return buzonCorreo;
    }

    public void agregarCorreo(Correo correo1) {
    }

    public void add(Correo correo2) {
    }

    
}
