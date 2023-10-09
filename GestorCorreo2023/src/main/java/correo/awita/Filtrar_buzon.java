package correo.awita;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Filtrar_buzon {
    public static List<Correo> filtro_enviados(Buzon buzon, Predicate<Correo> filtro){
        return buzon.getCorreosEnviados().stream().filter(filtro).collect(Collectors.toList());
    }

    public List<Correo> filtro_recibidos(Buzon buzon, Predicate<Correo> filtro){
        return buzon.getCorreosRecibidos().stream().filter(filtro).collect(Collectors.toList());
    }  
}
