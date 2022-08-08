package Vocabulary.ext;

public class IDCreator {
    private static IDCreator INSTANCE;
    private int indexID;
    private IDCreator(int configID) {
        this.indexID = configID;
    }

    public static IDCreator getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new IDCreator(0);
        }
        return INSTANCE;
    }

    public void configuration(int configID) {
        INSTANCE = new IDCreator(configID);
    }

    public ID getNewID() {
        return new ID(++indexID);
    }

    public ID getCurrentID() {
        return new ID(indexID);
    }
}
