package correo.awita;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validacion_Mail {
    public static boolean validar_correo(Contacto contacto){
        String patronCorreo = "^[A-Za-z0-9+_.-]+@(.+)$";
        
        Pattern pattern = Pattern.compile(patronCorreo);

        Matcher matcher = pattern.matcher(contacto.getMail());

        return matcher.matches();
    }        
}