package Messenger.model.sbj;

public class Client implements User {
    String fullName;

    public Client(String fullName) {
        this.fullName = fullName;
    }

    public String getFullName() {
        return fullName;
    }
}
