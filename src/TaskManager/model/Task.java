package TaskManager.model;

import TaskManager.ext.Worker;

import java.util.Calendar;

public class Task extends TaskModel {
    private Calendar dateTimeEnd;
    private StringBuilder comments;
    private Worker owner;

    Task(String name, Calendar dateTimeEnd) {
        super(name);
        this.dateTimeEnd = dateTimeEnd;
    }

    public void setDateTimeEnd(Calendar dateTimeEnd) {
        this.dateTimeEnd = dateTimeEnd;
    }

    @Override
    public String toString() {
        return String.format("Task: %s, DC: %s, DTE: %s, Assigned: %s",
                this.getName(), this.getDateCreation(), this.dateTimeEnd, this.owner);
    }
}
