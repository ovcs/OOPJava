package GenTree.gen;

public interface GTWatcher<T> {
    void showAncestors(T e);
    void showAll();
    void showFamily(T e);
}
