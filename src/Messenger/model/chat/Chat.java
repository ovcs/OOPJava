package Messenger.model.chat;

import Messenger.model.message.ContentModel;
import Messenger.model.sbj.Hub;
import Messenger.model.sbj.User;

import java.util.LinkedList;

public class Chat {
    String name;
    private final Hub<User> participates;
    private final LinkedList<ContentModel> listMessage;

    public Chat(Hub<User> participates, LinkedList<ContentModel> listMessage) {
        this.participates = participates;
        this.listMessage = listMessage;
    }

    public Chat(int countOfUsers) {
        participates = new Hub<>(countOfUsers);
        listMessage = new LinkedList<>();
    }

    public LinkedList<ContentModel> getListMessage() {
        return listMessage;
    }

    public Hub<User> getParticipates() {
        return participates;
    }
}
