public class App {
    public static void main(String[] args){

        Sistema sistema = new Sistema();
        sistema.registerUser(new Usuario("administrador", 1000, "admi", "1234", Rol.ADMINISTRATOR));
        

        

    }
}
