package TaskManager.ext;

public class User {
    private final String fullName;
    public static User none = new User("Unidentified user");

    public User(String fullName) {
        this.fullName = fullName;
    }

    public String getFullName() {
        return fullName;
    }

    @Override
    public String toString() {
        return fullName;
    }
}
