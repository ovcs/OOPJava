package Vocabulary.mdl;

public class Pair<T> extends BaseDaoEntity {
    private final T first;
    private final T second;

    public Pair(T first, T another) {
        super();
        this.first = first;
        this.second = another;
    }

    public T getFirst() {
        return first;
    }

    public T getSecond() {
        return second;
    }
}
