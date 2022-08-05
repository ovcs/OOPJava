package Messenger.rep;

import Messenger.model.chat.Chat;
import Messenger.model.message.Message;
import Messenger.model.sbj.User;

import java.util.List;

public interface DBMessenger {
    void add(User user);
    void add(Message message, Chat chat);
    List<User> getUsers();
    List<Chat> getChats(User user);
//    void getChat(String name);
    void removeMsg(Chat chat, List<Message> message);
}
