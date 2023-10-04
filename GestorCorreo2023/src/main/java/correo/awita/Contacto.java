package correo.awita;

public class Contacto {
    protected String nombre;
    protected String apellido;
    protected String mail;

    public Contacto(String nombre, String apellido, String mail){
        this.nombre = nombre;
        this.apellido = apellido;
        this.mail = mail;
    }
    
    public String getNombre() {
        return nombre;
    }
    public String getApellido() {
        return apellido;
    }
    public String getMail() {
        return mail;
    }

    public boolean contains(String criterio) {
        return false;
    }

}
