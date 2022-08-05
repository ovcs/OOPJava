package Messenger.model.sbj;

import Messenger.model.message.TextMessage;

public interface User {
    TextMessage createMsg(String text, Hub chatroom);
    void getAllM();
    void getUnreadM();
}
