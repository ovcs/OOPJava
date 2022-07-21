package GenTree.core;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface Hierarchy<T> extends Iterable<T> {
    int degree(T e);
    Set<T> getDegree(int degree);
    Set<T> getAll();
    Map<Integer, List<T>> getUpper(T e);
}
