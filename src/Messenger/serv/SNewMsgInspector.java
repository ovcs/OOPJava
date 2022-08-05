package Messenger.serv;

import Messenger.model.chat.Chat;
import Messenger.model.sbj.User;

import java.util.List;

public interface SNewMsgInspector {
    List<Chat> checkNewMessage(User user);
}
