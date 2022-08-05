package Messenger.model.sbj;

public class User implements Client {
    String fullName;

    public User(String fullName) {
        this.fullName = fullName;
    }

    public String getFullName() {
        return fullName;
    }
}
