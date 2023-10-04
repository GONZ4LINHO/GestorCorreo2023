package correo.awita;

import java.util.ArrayList;
import java.util.List;

public class Buzon {
    protected List<Correo> correosRecibidos;
    protected List<Correo> correosEnviados;

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
}
