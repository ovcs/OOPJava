package GeoTree.core.tree_module;


import GeoTree.core.model.*;

public class TreeCreator extends TreeController {

    public TreeCreator(Cell firstElement) {
        super(new Tree(firstElement));
    }

    public TreeCreator(Tree tree) {
        super(tree);
    }

    public void addBranch(Relationship relationship, CellObject cell) {
        addElement(new Relation(relationship));
        addElement(new Cell(cell));
    }

    private void addElement(TreeObject element) {
        tree.add(element);
        bind(cursor, tree.last());
        cursor = tree.last();
    }

    private void bind(int key, int value) {
        tree.get(key).addForward(value);
        tree.get(value).addBackward(key);
    }

    public Tree save() {
        return tree;
    }

    // TODO
    private void remove(int address) {

    }

    // TODO
    public void removeCell() {

    }
}
