package GenTree.gen;

import GenTree.core.HierarchicalTree;

public interface GTCreator<T> {
    void addBranch(T child, T parent);
    void change(T oldE, T newE);
    void create(T root);
    void removeBranch(T child, T parent);
    void remove(T cell);
    HierarchicalTree<T> save();
}
