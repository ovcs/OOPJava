package Messenger.model.message;

import Messenger.ext.ID;
import Messenger.ext.StaticCreator;
import Messenger.model.sbj.Client;

import java.util.Date;

public abstract class ContentModel {
    private final ID id;
    private final Date creationTime;
    private final Client creator;
    protected Object content;

    public ContentModel(Object content, Client creator) {
        this.id = StaticCreator.getNewIDFor(TextMessage.class);
        this.creationTime = StaticCreator.getDateTime();
        this.creator = creator;
        this.content = content;
    }

    public ID getId() {
        return id;
    }

    public Date getCreationTime() {
        return creationTime;
    }

    public Client getCreator() {
        return creator;
    }
}
