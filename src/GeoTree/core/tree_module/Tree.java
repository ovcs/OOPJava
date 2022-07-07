package GeoTree.core.tree_module;

import GeoTree.core.model.Cell;
import GeoTree.core.model.TreeObject;

import java.util.ArrayList;

/**
 * Дерево является хранилищем его же объектов TreeObjects. Так как, эти объекты имеют ссылочные связи между собой,
 * то было решено взять за основу ArrayList, и хранить ссылки в виде адреса на ячейки этого массива.
 */
public class Tree {
    ArrayList<TreeObject> tree;

    public Tree(Cell firstElement) {
        tree = new ArrayList<>();
        tree.add(firstElement);
    }

    public void add(TreeObject element) {
        tree.add(element);
    }

    public TreeObject get(int address) {
        return tree.get(address);
    }

    public int count() {
        return tree.size();
    }

//    public boolean contains(TreeObject element)

    public int last() {
        return tree.size() - 1;
    }

    public void remove(TreeObject element) {
        tree.remove(element);
    }
}
