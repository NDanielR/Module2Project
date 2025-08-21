public class Sistema {

    private Usuario[] usuarios = new Usuario[50];
    private Menu menu = new Menu();

    public void registerUser(Usuario nuevoUsuario) {
        boolean isAdd = false;

        for (int i = 0; i < usuarios.length; i++) {
            if (usuarios[i] == null) {
                usuarios[i] = nuevoUsuario;
                System.out.println("usuario agregado");
                nuevoUsuario.addEvent(createEvento(TipoEvento.INICIOSESION));
                isAdd = true;
                break;
            }
        }

        if (!isAdd) {
            System.out.println("no se pudo agregar usuario memoria llena");
        }
    }

    private Evento createEvento(TipoEvento tipoEvento) {

        switch (tipoEvento) {
            case INICIOSESION:
                return new Evento("Inicio de sesion", "El usuario inicio sesion");

            case CERRARSESION:
                return new Evento("Cierre de Sesion", "El usuario cerro la sesion");

            case ACTUALIZOUSUARIO:
                return new Evento("Actualizacion del usuario", "Se modificaron datos del usuario");

            case BORROUSUARIO:
                return new Evento("Borrado de usuario", "Se elimino un usuario desde esta cuenta");

            default:
                return new Evento("error", "error");
        }
    }

    public boolean signIn() {
        final int MAX_ATTEMPTS = 3;
        int attempts = 0;

        while (attempts < MAX_ATTEMPTS) {
            String userName = menu.enterUserName();
            String password = menu.enterPassword();

            boolean userFound = false;

            for (Usuario user : usuarios) {
                if (user == null)
                    continue;

                boolean sameUser = user.getUserName() != null && user.getUserName().equals(userName);

                if (sameUser) {
                    userFound = true;
                    if (user.getPassword() != null && user.getPassword().equals(password)) {
                        System.out.println("Inicio de sesión exitoso.");
                        user.addEvent(createEvento(TipoEvento.INICIOSESION));
                        return true;
                    } else {
                        break;
                    }
                }
            }

            attempts++;

            if (!userFound) {
                System.out.println("Usuario no encontrado.");
            } else {
                System.out.println("Contraseña incorrecta.");
            }
            System.out.printf("Intentos restantes: %d%n", (MAX_ATTEMPTS - attempts));
        }

        System.out.println("Número de intentos alcanzados. Adiós.");
        return false;
    }

    public void setUser (int index, Usuario user){
        usuarios[index] = user;
    }

    public Usuario[] getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(Usuario[] usuarios) {
        this.usuarios = usuarios;
    }
}
