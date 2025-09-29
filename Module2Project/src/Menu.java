import java.util.Scanner;

public class Menu {

    Scanner scn = new Scanner(System.in);

    public Usuario userInformation() {

        boolean informationOk = false;
        Usuario nuevoUsuario = null;

        do {
            try {
                System.out.println("Ingresa el nombre del nuevo usuario");
                String fullName = scn.nextLine();

                System.out.println("Ingresa un ID");
                Integer iD = Integer.parseInt(scn.nextLine());

                System.out.println("Ingresa un nombre de usuario");
                String userName = scn.nextLine();

                System.out.println("Ingresa una contraseña");
                String password = scn.nextLine();

                System.out.println("Selecciona el rol del usuario");

                nuevoUsuario = new Usuario(fullName, iD, userName, password, Rol.STANDARD);

                informationOk = true;
            } catch (NumberFormatException e) {
                System.out.println("Error: El ID debe ser un número válido. Intenta de nuevo.");
            } catch (Exception e) {
                System.out.println("Ocurrió un error inesperado: " + e.getMessage());
            }
        } while (!informationOk);

        return nuevoUsuario;
    }

    public boolean messengerWelcome() {

        while (true) {
            System.out.println("""
                    -----------------Bienvenido-----------------

                    Seleccione la opción que deseas realizar:

                    1. Iniciar sesión
                    2. Salir
                    """);

            String in = scn.nextLine().trim();
            if ("1".equals(in))
                return true;
            if ("2".equals(in))
                return false;
            System.out.println("Opción inválida. Intente de nuevo.");
        }
    }

    public String enterUserName() {
        System.out.println("Ingresa tu nombre de usuario:");
        String userName = scn.nextLine();
        return userName;
    }

    public String enterPassword() {
        System.out.println("Ingresa tu contraseña:");
        String password = scn.nextLine();
        return password;
    }

    public int menuAdm() {
        while (true) {
            System.out.println("""
                    Seleccione la opción que desea realizar:
                    1. Mostrar historial de eventos
                    2. Actualizar datos del usuario
                    3. Buscar usuarios
                    4. Crear usuario
                    5. Eliminar usuario
                    6. Modificar otro usuario
                    7. Cerrar sesión
                    8. Salir de la aplicación
                    """);

            String input = scn.nextLine().trim();
            try {
                int option = Integer.parseInt(input);
                if (option >= 1 && option <= 8)
                    return option;
                System.out.println("Opción fuera de rango.");
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Debe ser un número entre 1 y 8.");
            }
        }
    }

    public int menuStandard() {
        while (true) {
            System.out.println("""
                    Seleccione la opción que desea realizar:
                    1. Mostrar historial de eventos
                    2. Actualizar datos del usuario
                    3. Buscar usuarios
                    4. Cerrar sesión
                    5. Salir de la aplicación
                    """);

            String input = scn.nextLine().trim();
            try {
                int option = Integer.parseInt(input);
                if (option >= 1 && option <= 5)
                    return option;
                System.out.println("Opción fuera de rango.");
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Debe ser un número entre 1 y 5.");
            }
        }
    }

    public int menuModifyUser() {
        while (true) {
            System.out.println("""
                    Seleccione la informacion que desea actualizar
                    1. Nombre
                    2. Cedula
                    3. Nombre de usuario
                    4. Contraseña
                    """);

            String input = scn.nextLine().trim();
            try {
                int option = Integer.parseInt(input);
                if (option >= 1 && option <= 4) {
                    return option;
                } else {
                    System.out.println("Opción fuera de rango.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Debe ser un número entre 1 y 4.");

            }
        }
    }

    public String cambiarUsername() {
        while (true) {
            System.out.print("Ingresa nuevo username (@gmail.com): ");
            String e = scn.nextLine().trim().toLowerCase();
            if (e.endsWith("@gmail.com") && e.indexOf('@') > 0)
                return e;
            System.out.println("Debe terminar en @gmail.com.");
        }
    }

    public String cambiarPassword() {
        while (true) {
            System.out.print("Ingresa nueva contraseña (4 dígitos): ");
            String p = scn.nextLine().trim();
            if (p.length() == 4 && p.chars().allMatch(Character::isDigit))
                return p;
            System.out.println("Debe ser exactamente 4 números.");
        }
    }

    public String cambiarNombre() {
        while (true) {
            System.out.print("Ingresa el nuevo nombre: ");
            String n = scn.nextLine().trim();
            if (!n.isEmpty())
                return n;
            System.out.println("No puede estar vacío.");
        }
    }

    public int cambiarId() {
        while (true) {
            System.out.print("Ingresa nuevo ID: ");
            String s = scn.nextLine().trim();

            if (!s.isEmpty() && s.chars().allMatch(Character::isDigit)) {
                try {
                    int id = Integer.parseInt(s);
                    if (id > 0)
                        return id;
                } catch (NumberFormatException ignored) {
                }
            }
            System.out.println("Debe ser un entero positivo.");
        }
    }

    public void clearConsole() {
        System.out.println("Presiona ENTER para continuar.");
        scn.nextLine();
        try {
            String os = System.getProperty("os.name");

            if (os.contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls")
                        .inheritIO()
                        .start()
                        .waitFor();
            } else {
                new ProcessBuilder("clear")
                        .inheritIO()
                        .start()
                        .waitFor();
            }
        } catch (Exception e) {
            System.out.println("Error al limpiar la consola: " + e.getMessage());
        }
    }

    public int menuEliminarUser() {
        while (true) {
            System.out.print("Ingresa nuevo ID: ");
            String s = scn.nextLine().trim();

            if (!s.isEmpty() && s.chars().allMatch(Character::isDigit)) {
                try {
                    int id = Integer.parseInt(s);
                    if (id > 0)
                        return id;
                } catch (NumberFormatException ignored) {
                }
            }
            System.out.println("Debe ser un entero positivo.");
        }
    }
}
