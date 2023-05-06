public class Manager extends User{
    private String libraryId;
    public Manager(String userId, String password, String firstName, String lastName, String nationalId, int yearOfBirth, String address, String libraryId) {
        super(userId, password, firstName, lastName, nationalId, yearOfBirth, address);
        this.libraryId = libraryId;
    }
}
