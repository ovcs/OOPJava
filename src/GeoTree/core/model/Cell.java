package GeoTree.core.model;

public class Cell extends TreeObject {

    public Cell(CellObject value) {
        super(value);
    }
    @Override
    public CellObject getValue() {
        return (CellObject) super.getValue();
    }

    public void changeValue(CellObject value) {
        super.value = value;
    }
}
