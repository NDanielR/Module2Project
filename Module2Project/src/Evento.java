import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Evento {

    private String name;
    private String description;
    private LocalDateTime instant;

    public Evento(String name, String description){
        this.instant = LocalDateTime.now();
        this.name = name;
        this.description = description;
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
