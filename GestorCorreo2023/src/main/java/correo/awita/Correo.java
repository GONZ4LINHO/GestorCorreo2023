package correo.awita;

import java.util.List;

public class Correo {
    private String asunto;
    private String contenido;
    private Contacto remitente;
    private List<String> para;
    
    public String getAsunto() {
        return asunto;
    }

    public String getContenido() {
        return contenido;
    }

    public List<String> getPara() {
        return para;
    }

    public Contacto getRemitente() {
        return remitente;
    }

    public Correo(String asunto, String contenido, Contacto remitente, List<String> para){
        this.asunto = asunto;
        this.remitente = remitente;
        this.contenido = contenido;
        this.para = para;
    }
}