package Messenger.rep;

import Messenger.model.chat.Chat;
import Messenger.model.message.Message;
import Messenger.model.sbj.Client;
import Messenger.model.sbj.Hub;
import Messenger.model.sbj.User;

import java.util.*;

public class DAO implements DBMessenger {
    private final Map<User, Set<Chat>> clientSetMap;
    private final DT<User> users;
    private final DT<Chat> chats;

    public DAO(Map<User, Set<Chat>> clientSetMap, DT<User> users, DT<Chat> chats) {
        this.clientSetMap = clientSetMap;
        this.users = users;
        this.chats = chats;
    }

    public DAO() {
        this.clientSetMap = new HashMap<>();
        this.users = new DT<>();
        this.chats = new DT<>();
    }

    @Override
    public void add(User user) {
        users.add(user);
        clientSetMap.put(user, new LinkedHashSet<>());
    }

    public void add(Chat chat) {
        Hub<User> tmp = chat.getParticipates();
        users.addAll(tmp);
        chats.add(chat);
        tmp.forEach(e -> clientSetMap.get(e).add(chat));
    }
    @Override
    public void add(Message message, Chat chat) {
        chat.addMessage(message);
    }

    public boolean contains(User user) {
        return users.contains(user);
    }

    @Override
    public List<User> getUsers() {
        return new ArrayList<>(users);
    }

    @Override
    public List<Chat> getChats(User user) {
        return users.contains(user) ? new ArrayList<>(clientSetMap.get(user)) : new ArrayList<>();
    }

    @Override
    public void removeMsg(Chat chat, List<Message> messages) {
        chat.removeMessages(messages);
    }
}
