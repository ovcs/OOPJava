package TaskManager.model;

import java.util.*;

public interface TableModel<C, T> {
    void addDefault(T e);
    void add(C column, T e);
    void create();
    void changeOrder(C column, Comparator<T> comparator);
    C get(T e);
    Set<T> getIfContains(Object o);
    Set<T> getAll();
    void load(Map<C, T> table);
    void replace(T e, C toNewC);
    void remove(T e);
    Map<C, T> save();
}
