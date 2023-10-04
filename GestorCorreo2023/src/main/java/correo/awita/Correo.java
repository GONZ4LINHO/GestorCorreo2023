package correo.awita;

import java.util.List;

public class Correo {
    protected String asunto;
    protected String contenido;
    protected Contacto remitente;
    protected List<String> para;
    

    public String getAsunto() {
        return asunto;
    }
    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    public String getContenido() {
        return contenido;
    }
    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public List<String> getPara() {
        return para;
    }
    public void setPara(List<String> para) {
        this.para = para;
    }

    public Contacto getRemitente() {
        return remitente;
    }
    public void setRemitente(Contacto remitente) {
        this.remitente = remitente;
    }

    public Correo(String asunto, String contenido, Contacto remitente, List<String> para){
        this.asunto = asunto;
        this.remitente = remitente;
        this.contenido = contenido;
        this.para = para;
    }

}