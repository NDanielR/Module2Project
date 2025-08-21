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

    public void messengerWelcome(){
        System.out.println("-----Bienvenido-----");

    }

    public String enterUserName (){
        System.out.println("Ingresa tu nombre de usuario:");
        String userName = scn.nextLine();
        return userName;
    }

    public String enterPassword (){
        System.out.println("Ingresa tu contraseña:");
        String password = scn.nextLine();
        return password;
    }
}
