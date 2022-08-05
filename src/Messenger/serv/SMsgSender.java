package Messenger.serv;

import Messenger.model.chat.Chat;
import Messenger.model.sbj.User;

import java.util.List;

public interface SMsgSender {
    List<Chat> getChats(User user);
}
