package Messenger.rep;

import Messenger.model.chat.Chat;
import Messenger.model.sbj.Client;
import Messenger.model.sbj.Hub;

import java.util.Map;

public class DBChats {
    Map<Hub<Client>, Chat> chats;
}
