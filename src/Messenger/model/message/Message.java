package Messenger.model.message;

import Messenger.model.sbj.Client;
import Messenger.model.sbj.User;

import java.util.ArrayList;
import java.util.List;

public class Message extends ContentModel {
    public Message(Object content, User creator) {
        super(List.of(content), creator);
    }

    public Object getContent() {
        return this.content.get(0);
    }

    public void setContent(Object content) {
        this.content.add(0, content);
    }
}
