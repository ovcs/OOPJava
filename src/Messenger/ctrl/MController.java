package Messenger.ctrl;

import Messenger.model.chat.Chat;
import Messenger.model.sbj.User;

import java.util.List;

public interface MController {
    void addMessage(String text, Chat chat);
    List<Chat> getAllMessage(User user);
}
