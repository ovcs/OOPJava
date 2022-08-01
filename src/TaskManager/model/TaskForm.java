package TaskManager.model;

import TaskManager.ext.User;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Iterator;

public class TaskForm {
    protected User user;
    protected String text;
    protected int order;
    protected Calendar dateTimeEnd;

    public TaskForm(User user, String text, String order, String dateTimeEnd) {
        this.user = user;
        this.text = text;
        this.order = 0; // TODO
        SimpleDateFormat sdf = new SimpleDateFormat("dd MM yyyy");
        try {
            this.dateTimeEnd = Calendar.getInstance();
            this.dateTimeEnd.setTime(sdf.parse(dateTimeEnd));
        } catch (ParseException exc) {
            System.out.println(exc);
            this.dateTimeEnd = Calendar.getInstance();
        }

    }

    public String getText() {
        return text;
    }

    public int getPriority() {
        return order;
    }

    public User getUser() {
        return user;
    }

    public Calendar getDateTimeEnd() {
        return dateTimeEnd;
    }

    public Iterator<Object> iterator() {
        return new Iterator<>() {
            private static int index = 0;
            @Override
            public boolean hasNext() {
                return ++index < 4;
            }

            @Override
            public Object next() {
                return switch (index) {
                    case 1 -> user.toString();
                    case 2 -> text;
                    case 3 -> order;
                    case 4 -> dateTimeEnd;
                    default -> throw new IllegalStateException("Unexpected value: " + index);
                };
            }
        };
    }
}
