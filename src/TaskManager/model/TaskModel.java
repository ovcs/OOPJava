package TaskManager.model;

import java.util.Calendar;

public abstract class TaskModel implements Comparable<TaskModel> {
    private final int ID;
    private final Calendar DATE_CREATION;

    private String tName;

    private static int keyID = 0;

    TaskModel(String name) {
        ID = ++keyID;
        DATE_CREATION = Calendar.getInstance();
        this.tName = name;
    }

    public int getID() {
        return ID;
    }

    public Calendar getDateCreation() {
        return DATE_CREATION;
    }

    public String getName() {
        return tName;
    }

    public void setName(String name) {
        this.tName = name;
    }

    @Override
    public int compareTo(TaskModel tm) {
        return this.tName.compareTo(tm.tName);
    }
}


