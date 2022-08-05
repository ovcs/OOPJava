package Messenger.model.chat;

public class PersonalChat extends Chat {
    public PersonalChat() {
        super(2);
    }
    public PersonalChat(PersonalChat pc) {
        super(pc.getParticipates(), pc.getListMessage());
    }
}
