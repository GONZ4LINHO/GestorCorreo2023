package correo.awita;

public class Contacto {
    private String nombre;
    private String apellido;
    private String mail;

    public Contacto(String nombre, String apellido, String mail){
        this.nombre = nombre;
        this.apellido = apellido;
        this.mail = mail;
    }
    public String getApellido() {
        return apellido;
    }
    public String getMail() {
        return mail;
    }
    public String getNombre() {
        return nombre;
    }

    public boolean contains(String criterio) {
        return false;
    }

}
