package Messenger.rep;

import Messenger.model.message.ContentModel;

public interface DAOMessenger {
    void add(Chat chat);
    void add(User user);
    void add(ContentModel message, int chatID);
    void getUsers();
    List<Chat> getChats();
    void getChat(String name);
    void removeMsg(List<ContentModel> message);
}
