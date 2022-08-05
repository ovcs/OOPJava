package Messenger.model.message;

import Messenger.model.sbj.Client;
import Messenger.model.sbj.User;

public class TextMessage extends Message {

    public TextMessage(String text, User owner) {
        super(text, owner);
    }

    public String text() {
        return (String) this.getContent();
    }

    public void changeText(String text) {
        this.setContent(text);
    }
}
