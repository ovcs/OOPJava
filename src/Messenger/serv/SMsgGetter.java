package Messenger.serv;

import Messenger.model.chat.Chat;
import Messenger.model.message.Message;
import Messenger.model.sbj.User;

public interface SMsgGetter {
    Message createMessage(Object serialize, User user);
    void addMessageTo(Message msg, Chat chat);
}
