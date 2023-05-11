public class User {
    private String userId;
    private String password;
    private String firstName;
    private String lastName;
    private String nationalId;
    private int yearOfBirth;
    private String address;
    public User(String userId, String password, String firstName, String lastName, String nationalId, int yearOfBirth, String address){
        this.userId = userId;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.nationalId = nationalId;
        this.yearOfBirth = yearOfBirth;
        this.address = address;
    }

    public String getUserId() {
        return userId;
    }

    public String getPassword() {
        return password;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}
