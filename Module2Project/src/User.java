public class User {

    private String firstName;
    private String lastName;
    private Integer id;
    private String userName;
    private String password;
    private Rol rol;

    public User(String firstName, String lastName, Integer id, String userName, String password, Rol rol) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.rol = rol;
    }

    public String randomUsername(String firstName, String lastName) {
        
        firstName = firstName.replace(" ", "");
        lastName = lastName.replace(" ", "");

        firstName = firstName.length() >= 3 ? firstName.substring(0, 3)
                : String.format("%-3s", firstName).replace(' ', 'x');

        lastName = lastName.length() >= 3 ? lastName.substring(0, 3)
                : String.format("%-3s", lastName).replace(' ', 'x');

        return (firstName + lastName).toLowerCase();
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
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
}
