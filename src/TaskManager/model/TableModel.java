package TaskManager.model;

import java.util.*;

public interface TableModel<R, T> {
                   void addDefault(T e);
                   void add(R r, T e);
                   void create();
                   void changeOrder(Comparator<T> comparator);
                      R get(T e);
                 Set<T> getIfContains(Object o);
                 Map<R, T> getTable();
                 Set<T> getAll();
                   void load(Map<R, T> loadTable);
                   void replace(T e, R newR);
                   void remove(T e);
}
