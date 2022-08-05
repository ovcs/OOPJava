package Messenger.rep;

import Messenger.model.chat.Chat;
import Messenger.model.sbj.Client;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class DAOManager {
    private final Map<Client, Set<Chat>> clientSetMap;
    private final List<DT> DTS;

    public DAOManager(Map<Client, Set<Chat>> clientSetMap, List<DT> DTS) {
        this.clientSetMap = clientSetMap;
        this.DTS = DTS;
    }
}
