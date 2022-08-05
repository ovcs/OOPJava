package Messenger;

import Messenger.ctrl.UserManager;
import Messenger.model.chat.Chat;
import Messenger.model.sbj.Hub;
import Messenger.model.sbj.User;
import Messenger.rep.DAO;
import Messenger.rep.DT;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Testing {
    public static void main(String[] args) {
        User client = new User("Клиент 1");
        DAO dao = new DAO();
        UserManager um = new UserManager(client, dao);
        um.getService().createNewChat(List.of(client));
        Chat chatted = um.getAllMessage(client).get(0);
        um.addMessage("Привет", chatted);
        System.out.println("Well Done");
    }
}
