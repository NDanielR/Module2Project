public class Sistema {

    private Usuario[] usuarios = new Usuario[50];
    private Menu menu = new Menu();

    public Sistema() {
        registerUser(userMaster());
    }

    public void start() {

        menu.clearConsole();

        while (true) {
            boolean goLogin = menu.messengerWelcome(); 
            if (!goLogin) {
                System.out.println("Saliendo de la aplicación...");
                return;
            }

            Usuario user = signIn();
            if (user == null) {
                continue;
            }

            boolean exitApp = mainMenu(user); 
            if (exitApp) {
                System.out.println("Saliendo de la aplicación...");
                return;
            }
        }
    }

    private boolean mainMenu(Usuario user) {
        boolean admin = (user.getRol() == Rol.ADMINISTRATOR);

        while (true) {
            int option = admin ? menu.menuAdm() : menu.menuStandard();

            switch (option) {
                case 1:
                    user.viewHistory();
                    menu.clearConsole();
                    break;

                case 2:
                    modifyUser(user);
                    menu.clearConsole();
                    break;

                case 3:
                    printListUser();
                    menu.clearConsole();
                    break;

                case 4:
                    if (admin) {
                        addUser();
                        user.addEvent(createEvento(TipoEvento.CREARUSUARIO));
                        menu.clearConsole();
                    } else {
                        user.addEvent(createEvento(TipoEvento.CERRARSESION));
                        return false; 
                    }
                    break;

                case 5:
                    if (admin) {
                        borrarPorId(menu.menuEliminarUser());
                        user.addEvent(createEvento(TipoEvento.BORROUSUARIO));
                        menu.clearConsole();
                    } else {
                        user.addEvent(createEvento(TipoEvento.CERRARSESION));
                        return true; 
                    }
                    break;

                case 6:
                    if (admin) {
                        modifyUser(null);
                        menu.clearConsole();
                    } else {
                        System.out.println("Opción inválida.");
                    }
                    break;

                case 7: 
                    if (admin) {
                        user.addEvent(createEvento(TipoEvento.CERRARSESION));
                        return false; 
                    }
                    System.out.println("Opción inválida.");
                    break;

                case 8:
                    if (admin) {
                        user.addEvent(createEvento(TipoEvento.CERRARSESION));
                        return true;
                    }
                    System.out.println("Opción inválida.");
                    break;

                default:
                    System.out.println("Opción inválida.");
                    menu.clearConsole();
                    break;
            }
        }
    }

    public void addUser() {

        boolean confirmation = registerUser(menu.userInformation());

        if (confirmation) {
            System.out.println("usuario agregado");
        } else {
            System.out.println("no fue posible agregar el usuario");
            System.out.println("no se pudo agregar usuario memoria llena");
        }
    }

    private void printListUser() {
        for (Usuario usuario : usuarios) {
            if (usuario == null)
                continue;
            System.out.println(usuario.toString());
        }
    }

    private Usuario signIn() {
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
                        menu.clearConsole();
                        return user;
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
        return null;
    }

    public void setUser(int index, Usuario user) {
        usuarios[index] = user;
    }

    private boolean registerUser(Usuario nuevoUsuario) {
        boolean isAdd = false;

        for (int i = 0; i < usuarios.length; i++) {
            if (usuarios[i] == null) {
                usuarios[i] = nuevoUsuario;
                nuevoUsuario.addEvent(createEvento(TipoEvento.INICIOSESION));
                isAdd = true;
                break;
            }
        }

        return isAdd;
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

            case CREARUSUARIO:
                return new Evento("Usuario Creado", "Se creo usuario");


            default:
                return new Evento("error", "error");
        }
    }

    private Usuario userMaster() {
        return new Usuario("administrador", 1000, "admi", "1234", Rol.ADMINISTRATOR);
    }

    private void modifyUser(Usuario user) {

        int option = menu.menuModifyUser();

        switch (option) {
            case 1:
                user.setFullName(menu.cambiarNombre());
                user.addEvent(createEvento(TipoEvento.ACTUALIZOUSUARIO));
                break;

            case 2:
                user.setId(menu.cambiarId());
                user.addEvent(createEvento(TipoEvento.ACTUALIZOUSUARIO));
                break;

            case 3:
                user.setUserName(menu.cambiarUsername());
                user.addEvent(createEvento(TipoEvento.ACTUALIZOUSUARIO));
                break;

            case 4:
                user.setPassword(menu.cambiarPassword());
                user.addEvent(createEvento(TipoEvento.ACTUALIZOUSUARIO));
                break;

            default:
                System.out.println("opcion no valida");
                break;
        }

    }

    private boolean borrarPorId(int id) {
        for (int i = 0; i < usuarios.length; i++) {
            Usuario u = usuarios[i];
            if (u != null && u.getId() != null && u.getId() == id) {
                usuarios[i] = null;
                return true;
            }
        }
        return false;
    }

}
