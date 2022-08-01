package TaskManager.model;

import java.util.*;

public class DB<R extends Record> {
    private final Map<Integer, R> collection;

    public DB() {
        this.collection = new HashMap<>();
    }

    public DB(List<R> collection) {
        this();
        if (collection != null) collection.forEach(i -> this.collection.put(i.ID, i));
    }

    public R getElementBy(int ID) {
        return collection.get(ID);
    }

    public List<R> findBy(String s) {
        List<R> newL = new ArrayList<>();
        for (var r : collection.values()) {
            Iterator<Object> i = r.iterator();
            while (i.hasNext()) {
                if (i.next().toString().contains(s)) {
                    newL.add(r);
                }
            }
        }
        return newL;
    }
    public List<R> importAll() {
        return new ArrayList<>(collection.values());
    }

    public boolean remove(R r) {
        return collection.remove(r.ID) != null;
    }

    public void update(R r) {
        collection.put(r.ID, r);
    }
}
