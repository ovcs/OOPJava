package GeoTree.core.tree_module;

import GeoTree.core.model.CellObject;

/**
 * Основая абстрактная программа для работы с деревом.
 */
public abstract class TreeController {

    protected final Tree tree;
    protected int cursor;

    public TreeController(Tree tree) {
        this.tree = tree;
        cursor = this.tree.last();
    }

    public void checkout(int address) {
        cursor = address;
    }

    public void checkoutLast() {
        cursor = tree.last();
    }

//    TODO
    public void contains(CellObject object) {

    }

    public void showCurrent() {
        System.out.println(tree.get(cursor).getValue());
    }
}
