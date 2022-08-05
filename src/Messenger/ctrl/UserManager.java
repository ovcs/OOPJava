package Messenger.ctrl;

import Messenger.model.chat.Chat;
import Messenger.model.sbj.User;
import Messenger.rep.DAO;
import Messenger.serv.Service;

import java.util.List;

public class UserManager implements MController {
    private User user;
    private final Service service;

    public UserManager(User user, DAO dao) {
        this.user = user;
        service = new Service(dao);
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Service getService() {
        return service;
    }

    @Override
    public void addMessage(String text, Chat chat) {
        service.addMessageTo(service.createMessage(text, user), chat);
    }

    @Override
    public List<Chat> getAllMessage(User user) {
        return service.getChats(user);
    }
}
