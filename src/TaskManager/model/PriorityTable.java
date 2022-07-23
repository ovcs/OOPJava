package TaskManager.model;

import java.util.*;

public class PriorityTable<P extends Enum<P>, T> extends EnumMap<P, TreeSet<T>> {

    public PriorityTable(Class<P> p, Comparator<T> comparator) {
        super(p);
        for (var k : this.keySet())
            this.put(k, new TreeSet<>(comparator));
    }

    @Override
    public int size() {
        int len = 0;
        for (var v : this.values()) {
            len += v.size();
        }
        return len;
    }

    TreeSet<T> getValues(P priority) {
        return this.get(priority);
    }

    boolean add(P priority, T obj) {
        return this.get(priority).add(obj);
    }

    boolean updatePriorityFrom(T obj, P newP) {
        return this.removeElement(obj) && this.add(newP, obj);
    }

    boolean removeElement(T obj) {
        for (var p : this.keySet())
            if (this.get(p).remove(obj))
                return true;
        return false;
    }
}
