public class Usuario {

    private String fullName;
    private Integer id;
    private String userName;
    private String password;
    private Rol rol;
    private Evento[] history = new Evento[100];

    public Usuario(String fullName, Integer id, String userName, String password, Rol rol) {
        this.fullName = fullName;
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.rol = rol;
    }

    public String getFullName() {
        return fullName;
    }

    public Integer getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public Rol getRol() {
        return rol;
    }

    public void viewHistory() {

        System.out.printf("%-5s %-20s %-30s %-20s%n", "N°", "Nombre", "Descripción", "Fecha y Hora");
        System.out.println("--------------------------------------------------------------------------");
        int i = 1;
        for (Evento evento : history) {
            System.out.printf("%-5d%s%n", i++, evento.toString());
        }
    }

    public void addEvent(Evento nuevoEvento) {
        boolean agregado = false;

        for (int i = 0; i < history.length; i++) {
            if (history[i] == null) {
                history[i] = nuevoEvento;
                agregado = true;
                break;
            }
        }

        if (!agregado) {
            System.out.println("No se pudo agregar el evento. El historial está lleno.");
        }
    }
}
