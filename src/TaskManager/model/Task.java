package TaskManager.model;

import TaskManager.ext.User;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Iterator;

public class Task extends Record implements Serializable {
    private String text;
    private Calendar dateTimeEnd;
    private int order;

    public static Task task = new Task(0,null,null,null,null,0);

    public Task(int id, Calendar dateCreation, User owner, String text, Calendar dateTimeEnd, int order) {
        super(id, dateCreation, owner);
        this.text = text;
        this.dateTimeEnd = dateTimeEnd;
        this.order = order;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Calendar getDateTimeEnd() {
        return dateTimeEnd;
    }

    public void setDateTimeEnd(Calendar dateTimeEnd) {
        this.dateTimeEnd = dateTimeEnd;
    }

    public int getPriority() {
        return order;
    }

    public void setPriority(int order) {
        this.order = order;
    }

    public void setDone() {
        this.order = order > -1 ? -1 : 0;
    }

    @Override
    public Iterator<Object> iterator() {
        return new Iterator<>() {
            private static int index = 0;
            @Override
            public boolean hasNext() {
                return ++index < 6;
            }

            @Override
            public Object next() {
                return switch (index) {
                    case 0 -> ID;
                    case 1 -> DATE_CREATION;
                    case 2 -> owner;
                    case 3 -> text;
                    case 4 -> dateTimeEnd;
                    case 5 -> order;
                    default -> throw new IllegalStateException("Unexpected value: " + index);
                };
            }
        };
    }
}
