public class App {
    public static void main(String[] args){

        Usuario usuario1 = new Usuario("Nelson Daniel Ramirez", 1090474274, "n.daniel@gmail.com", "1234", Rol.ADMINISTRATOR);

        usuario1.addEvent(new Evento(Evento.INICIOSESION));
    }
}
