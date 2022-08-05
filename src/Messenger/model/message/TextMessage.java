package Messenger.model.message;

import Messenger.model.sbj.Client;

public class TextMessage extends ContentModel {

    public TextMessage(String text, Client owner) {
        super(text, owner);
    }

    public String text() {
        return (String) content;
    }

    public void changeText(String text) {
        this.content = text;
    }
}
