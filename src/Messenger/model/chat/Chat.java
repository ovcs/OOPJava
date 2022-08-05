package Messenger.model.chat;

import Messenger.model.message.ContentModel;
import Messenger.model.message.Message;
import Messenger.model.sbj.Hub;
import Messenger.model.sbj.User;

import java.util.LinkedList;
import java.util.List;

public class Chat {
    String name;
    private final Hub<User> participates;
    private final LinkedList<Message> listMessage;

    public Chat(Hub<User> participates, LinkedList<Message> listMessage) {
        this.participates = participates;
        this.listMessage = listMessage;
    }

    public Chat(int countOfUsers) {
        participates = new Hub<>(countOfUsers);
        listMessage = new LinkedList<>();
    }

    public void addMessage(Message msg) {
        listMessage.add(msg);
    }

    public void removeMessages(List<Message> msgs) {
        msgs.forEach(listMessage::remove);
    }

    public LinkedList<Message> getListMessage() {
        return listMessage;
    }

    public Hub<User> getParticipates() {
        return participates;
    }
}
