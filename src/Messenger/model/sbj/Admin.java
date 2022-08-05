package Messenger.model.sbj;

import Messenger.model.chat.Chat;

public class Admin extends User{

    public Admin(String fullName) {
        super(fullName);
    }

    public void deleteFrom(Chat chat, User user) {
        chat.getParticipates().remove(user);
    }
}
