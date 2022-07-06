package GeoTree.core.tree_module;


import GeoTree.core.model.Relation;
import GeoTree.core.model.Relationship;
import GeoTree.core.model.TreeObject;

public class TreeWatcher extends TreeController {

    StringBuilder sb;

    public TreeWatcher(Tree tree) {
        super(tree);
        sb = new StringBuilder();
    }

    public void printAllAncestors() {
        sb.append(tree.get(0).getValue()).append("\n");
        formatElements(tree.get(0));
        System.out.println(sb);
    }

    private void formatElements(TreeObject cell) {
        if (cell.getForwardCells().isEmpty()) { sb.append("\n"); return; }
        for (int item : cell.getForwardCells()) {
            if (tree.get(item).getValue() == Relationship.HEREDITARY) {
                TreeObject newCell = tree.get(tree.get(item).getForwardCells().get(0));
                sb.append(newCell.getValue()).append("    ");
                formatElements(newCell);
            }
        }
    }
}
