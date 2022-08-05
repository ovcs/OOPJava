package Messenger.model.chat;

public class GroupChat extends Chat {
    public GroupChat() {
        super(Integer.MAX_VALUE);
    }

    public GroupChat(GroupChat gc) {
        super(gc.getParticipates(), gc.getListMessage());
    }
}
