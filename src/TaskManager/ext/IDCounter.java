package TaskManager.ext;

public class IDCounter {
    private static IDCounter INSTANCE;
    private int ID;
    private IDCounter(int configID) {
        this.ID = configID;
    }

    public static IDCounter getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new IDCounter(0);
        }
        return INSTANCE;
    }

    public void configuration(int configID) {
        INSTANCE = new IDCounter(configID);
    }

    public int getNewID() {
        return ++ID;
    }

}
