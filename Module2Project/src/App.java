public class App {
    public static void main(String[] args){

        Sistema sistema = new Sistema();
        sistema.printListUser();
        sistema.mainMenu(sistema.signIn());
    }
}
