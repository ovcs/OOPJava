package Messenger.model.sbj;

// TODO Написать отдельно объект системы, отдельно объект, который может обмениваться сообщениями
public class User {
    String fullName;

    public User(String fullName) {
        this.fullName = fullName;
    }

    public String getFullName() {
        return fullName;
    }
}
