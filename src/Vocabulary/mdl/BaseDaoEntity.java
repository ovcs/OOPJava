package Vocabulary.mdl;

import Vocabulary.ext.ID;
import Vocabulary.ext.IDCreator;

public abstract class BaseDaoEntity {
    private final ID id;

    public BaseDaoEntity(ID id) {
        this.id = id;
    }

    public BaseDaoEntity() {
        this(IDCreator.getInstance().getNewID());
    }

    public ID getId() {
        return id;
    }
}
