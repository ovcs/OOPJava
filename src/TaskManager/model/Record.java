package TaskManager.model;

import TaskManager.ext.User;

import java.util.Calendar;
import java.util.Iterator;

public abstract class Record implements Comparable<Record> {
    protected final int ID;
    protected final Calendar DATE_CREATION;
    protected User owner;

    public Record(int id, Calendar dateCreation, User owner) {
        this.ID = id;
        this.DATE_CREATION = dateCreation == null ? Calendar.getInstance() : dateCreation;
        this.owner = owner == null ? User.none : owner;
    }

    public Calendar getDateCreation() {
        return DATE_CREATION;
    }

    public int getID() {
        return ID;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    @Override
    public int compareTo(Record o) {
        return Integer.compare(this.ID, o.ID);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Record record = (Record) o;
        return ID == record.ID;
    }

    public Iterator<Object> iterator() {
        return new Iterator<>() {
            private static int index = 0;
            @Override
            public boolean hasNext() {
                return ++index < 3 ;
            }

            @Override
            public Object next() {
                return switch (index) {
                    case 0 -> ID;
                    case 1 -> DATE_CREATION;
                    case 2 -> owner;
                    default -> this.toString();
                };
            }
        };
    }

    @Override
    public String toString() {
        return String.format("%s %s %s ", ID, DATE_CREATION, owner);
    }
}


