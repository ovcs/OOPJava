package Messenger.serv;

import Messenger.model.chat.Chat;
import Messenger.model.message.Message;
import Messenger.model.sbj.Hub;
import Messenger.model.sbj.User;
import Messenger.rep.DAO;

import java.util.LinkedList;
import java.util.List;

public class Service implements SMsgGetter, SMsgSender {
    private final DAO dao;

    public Service(DAO dao) {
        this.dao = dao;
    }

    boolean checkUser(User user) {
        return dao.contains(user);
    }

    @Override
    public Message createMessage(Object serialize, User user) {
        return new Message(serialize, user);
    }

    @Override
    public void addMessageTo(Message msg, Chat chat) {
        dao.add(msg, chat);
    }

    public void createNewChat(List<User> users) {
        dao.add(new Chat(new Hub<>(users), new LinkedList<>()));
    }
    @Override
    public List<Chat> getChats(User user) {
        return dao.getChats(user);
    }
}
