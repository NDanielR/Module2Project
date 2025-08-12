import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Evento {

    public static final int INICIOSESION = 1;
    public static final int CERRARSESION = 2;
    public static final int ACTUALIZOUSUARIO = 3;
    public static final int BORROUSUARIO = 4;

    private String name;
    private String description;
    private LocalDateTime instant;

    public Evento(int tipoEvento){

        this.instant = LocalDateTime.now();
       
        switch (tipoEvento) {
            case INICIOSESION:
                this.name = "Inicio de Sesion";
                this.description = "El usuario inicio sesion";
                break;

            case CERRARSESION:
                this.name = "Cierre de Sesion";
                this.description = "El usuario cerro la sesion";

            case ACTUALIZOUSUARIO:
                this.name = "Actualizacion del usuario";
                this.description = "Se modificaron datos del usuario";

            case BORROUSUARIO:
                this.name = "Borrado de usuario";
                this.description = "Se elimino un usuario desde esta cuenta";
        
            default:
                this.name = "error";
                this.description = "error";
                break;
        }
    }
    
    public String getName() {
        return name;
    }
    public String getDescription() {
        return description;
    }
    public LocalDateTime getInstant() {
        return instant;
    }

    @Override
    public String toString(){
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        return String.format(
            "%-5s %-20s %-30s %-20s",
            "", 
            getName(),
            getDescription(),
            getInstant().format(formato)
        );
    }
    

}
